package com.atguigu.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * @author : wangebie
 * @date : 2021/2/9 13:54
 */
public interface AccountService {
    /**
     * 扣减账户余额
     *
     * @param userId user id
     * @param money  money
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
