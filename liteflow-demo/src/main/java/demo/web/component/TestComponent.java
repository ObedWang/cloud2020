package demo.web.component;

import com.alibaba.fastjson.JSON;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.entity.data.Slot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author : wangebie
 * @date : 2021/1/18 9:55
 */
@Slf4j
@Component("testComponent")
public class TestComponent extends NodeComponent {
    @Override
    public void process() throws Exception {
        //slot 为这个请求的上下文
        Slot slot = this.getSlot();
        // business logical
        String data = slot.getData("hello");
        log.info("start flow");
        log.info(data);
        slot.setData("world","world");
    }

    @Override
    public boolean isAccess() {
        Slot slot = this.getSlot();
        //这里做你的参数检查，如果没获取到必须的业务参数，就不会进入该组件
        //模拟检查结果为true
        boolean checkResult = true;
        return checkResult;
    }

    @Override
    public boolean isContinueOnError() {
        return super.isContinueOnError();
    }

    @Override
    public boolean isEnd() {
        return super.isEnd();
    }
}
