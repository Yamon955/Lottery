package com.lottery.domain.strategy.service.draw;

import com.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.lottery.infrastructure.po.StrategyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yamon
 * @Create 2023/12/19 23:31
 */
public class DrawBase extends DrawConfig{

    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList){
        if(1 != strategyMode) return; // ？？？
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) return;

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList){
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }
}
