package com.atguigu.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : wangebie
 * @date : 2021/1/5 14:44
 */
@RestController
public class KafkaController {
    @Resource
    KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/api/kafka/hello")
    public String producer(){
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send("testTopic", "hello world");
        send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                System.out.println("success");
            }
        });
        return null;
    }

    @KafkaListener(topics = "testTopic")
    public void consume(String data, Acknowledgment acknowledgment){
        System.out.println(data);
        acknowledgment.acknowledge();
    }
}
