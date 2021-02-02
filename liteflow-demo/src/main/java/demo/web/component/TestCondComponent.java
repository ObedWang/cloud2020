package demo.web.component;

import com.yomahub.liteflow.core.NodeCondComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author : wangebie
 * @date : 2021/1/18 10:26
 */
@Slf4j
@Component("cond")
public class TestCondComponent extends NodeCondComponent {
    @Override
    public String processCond() throws Exception {
        return "testComponent2";
    }
}
