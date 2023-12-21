package com.lottery.domain.strategy.service.algorithm.impl;

import com.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;

/**
 * @Description 单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 * @Author Yamon
 * @Create 2023/12/19 20:45
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    // 数组初始化长度
    private final int RATE_TUPLE_LENGTH = 128;

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        // 获取策略对应的元组
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;

        //随机索引
        int randomVal = new SecureRandom().nextInt(100) + 1;
        int idx = super.hashIdx(randomVal);

        //返回结果
        String awardId = rateTuple[idx];

        //如果中奖ID命中排除奖品列表，则返回null
        if(excludeAwardIds.contains(awardId)){
            return null;
        }

        return awardId;
    }

}
