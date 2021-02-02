package com.atguigu.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import zipkin2.Call;
import zipkin2.Callback;
import zipkin2.CheckResult;
import zipkin2.Span;
import zipkin2.codec.BytesEncoder;
import zipkin2.codec.Encoding;
import zipkin2.codec.SpanBytesEncoder;
import zipkin2.reporter.BytesMessageEncoder;
import zipkin2.reporter.Sender;

import java.io.IOException;
import java.net.URI;
import java.util.List;

/**
 * @author : wangebie
 * @date : 2021/1/21 17:35
 */
@Slf4j
final class MyRestTemplateSender extends Sender {
    final RestTemplate restTemplate;
    final String url;
    final Encoding encoding;
    final MediaType mediaType;
    final BytesMessageEncoder messageEncoder;
    transient boolean closeCalled;

    MyRestTemplateSender(RestTemplate restTemplate, String baseUrl, BytesEncoder<Span> encoder) {
        this.restTemplate = restTemplate;
        this.encoding = encoder.encoding();
        if (encoder.equals(SpanBytesEncoder.JSON_V2)) {
            this.mediaType = MediaType.APPLICATION_JSON;
            this.url = baseUrl + (baseUrl.endsWith("/") ? "" : "/") + "api/v2/spans";
        } else if (this.encoding == Encoding.PROTO3) {
            this.mediaType = MediaType.parseMediaType("application/x-protobuf");
            this.url = baseUrl + (baseUrl.endsWith("/") ? "" : "/") + "api/v2/spans";
        } else {
            if (this.encoding != Encoding.JSON) {
                throw new UnsupportedOperationException("Unsupported encoding: " + this.encoding.name());
            }

            this.mediaType = MediaType.APPLICATION_JSON;
            this.url = baseUrl + (baseUrl.endsWith("/") ? "" : "/") + "api/v1/spans";
        }

        this.messageEncoder = BytesMessageEncoder.forEncoding(this.encoding);
    }

    @Override
    public Encoding encoding() {
        return this.encoding;
    }

    @Override
    public int messageMaxBytes() {
        return 5242880;
    }

    @Override
    public int messageSizeInBytes(List<byte[]> spans) {
        return this.encoding().listSizeInBytes(spans);
    }

    @Override
    public Call<Void> sendSpans(List<byte[]> encodedSpans) {
        for (byte[] arr : encodedSpans) {
            String str = new String(arr);
            log.info(str);
        }

        if (this.closeCalled) {
            throw new IllegalStateException("close");
        } else {
            log.info("start to send zipkin msg");
            return new MyRestTemplateSender.HttpPostCall(this.messageEncoder.encode(encodedSpans));
        }
    }

    @Override
    public CheckResult check() {
        try {
            this.post(new byte[]{91, 93});
            return CheckResult.OK;
        } catch (Exception var2) {
            return CheckResult.failed(var2);
        }
    }

    @Override
    public void close() {
        this.closeCalled = true;
    }

    void post(byte[] json) {
        log.info(new String(json));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(this.mediaType);
        RequestEntity<byte[]> requestEntity = new RequestEntity(json, httpHeaders, HttpMethod.POST, URI.create(this.url));
        ResponseEntity<String> exchange = this.restTemplate.exchange(requestEntity, String.class);
        log.info(exchange.getStatusCode().toString());
        log.info(exchange.toString());
    }

    class HttpPostCall extends Call.Base<Void> {
        private final byte[] message;

        HttpPostCall(byte[] message) {
            this.message = message;
        }

        @Override
        protected Void doExecute() throws IOException {
            MyRestTemplateSender.this.post(this.message);
            return null;
        }

        @Override
        protected void doEnqueue(Callback<Void> callback) {
            try {
                MyRestTemplateSender.this.post(this.message);
//                callback.onSuccess((Object)null);
            } catch (Error | RuntimeException var3) {
                callback.onError(var3);
            }

        }

        @Override
        public Call<Void> clone() {
            return MyRestTemplateSender.this.new HttpPostCall(this.message);
        }
    }
}
