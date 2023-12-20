package com.lottery.domain.strategy.service.algorithm.impl;

import com.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * @Author Yamon
 * @Create 2023/12/19 20:45
 * 【推荐】单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

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
        if(excludeAwardIds.contains(awardId)) return "未中奖";

        return awardId;

    }
}
