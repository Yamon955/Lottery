package com.lottery.domain.strategy.service.algorithm.impl;

import com.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 必中奖策略抽奖，排除掉已经中将的概率，重新计算中奖的范围
 * @Author Yamon
 * @Create 2023/12/19 20:10
 */
@Component("entiretyRateRandomDrawAlgorithm")
public class EntiretyRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        BigDecimal differenceDenominator = BigDecimal.ZERO;

        // 排除掉不在抽奖范围的奖品ID集合
        List<AwardRateInfo> differenceAwardRateList = new ArrayList<>();
        List<AwardRateInfo> awardRateIntervalValList = awardRateInfoMap.get(strategyId);
        for(AwardRateInfo awardRateInfo : awardRateIntervalValList){
            String awardId = awardRateInfo.getAwardId();
            if(excludeAwardIds.contains(awardId)){
                continue;
            }
            differenceAwardRateList.add(awardRateInfo);
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }

        //前置判断：奖品列表为0，返回 null
        if(differenceAwardRateList.size() == 0) return null;

        //前置判断：奖品列表为1，直接返回
        if(differenceAwardRateList.size() == 1) return differenceAwardRateList.get(0).getAwardId();

        //获取随机概率值
        int randomVal = this.generateSecureRandomIntCode(100);

        //循环奖品
        String awardId = null;
        int cursorVal = 0;
        for (AwardRateInfo awardRateInfo : differenceAwardRateList){
            //scale参数表示保留小数的位数，BigDecimal.ROUND_UP表示进位方式：直接进位
            int rateVal = awardRateInfo.getAwardRate().divide(differenceDenominator, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();
            if (randomVal <= (cursorVal + rateVal)){
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorVal += rateVal;
        }

        //返回中将结果
        return awardId;
    }

    @Override
    public void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        // 保存奖品概率信息
        //对于总体概率抽奖只需要初始化 awardRateInfoMap 即可，总体概率抽奖过程 randomDraw 只用到了 awardRateInfoMap,不需要初始化 rateTupleMap
        awardRateInfoMap.put(strategyId, awardRateInfoList);
    }
}
