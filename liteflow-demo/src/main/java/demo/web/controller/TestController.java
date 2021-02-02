package demo.web.controller;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.entity.data.DefaultSlot;
import com.yomahub.liteflow.entity.data.Slot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : wangebie
 * @date : 2021/1/18 10:32
 */
@RestController
public class TestController {

    @Resource
    FlowExecutor flowExecutor;

    @GetMapping("/chain")
    public Object startChain() throws Exception{
        Slot slot = new DefaultSlot();
        slot.setData("hello","hello");
        return flowExecutor.execute("chain1",slot);
    }
}
