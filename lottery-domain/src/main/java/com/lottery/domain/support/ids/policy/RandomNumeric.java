package com.lottery.domain.support.ids.policy;

import com.lottery.domain.support.ids.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @Description 工具类生成 org.apache.commons.lang3.RandomStringUtils
 * @Author Yamon
 * @Create 2023/12/25 14:01
 */
@Component
public class RandomNumeric implements IIdGenerator {

    @Override
    public long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
