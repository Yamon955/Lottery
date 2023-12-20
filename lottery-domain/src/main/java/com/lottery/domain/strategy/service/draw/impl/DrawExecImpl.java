package com.lottery.domain.strategy.service.draw.impl;

import com.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.lottery.domain.strategy.model.req.DrawReq;
import com.lottery.domain.strategy.model.res.DrawResult;
import com.lottery.domain.strategy.repository.IStrategyRepository;
import com.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.lottery.domain.strategy.service.draw.DrawBase;
import com.lottery.domain.strategy.service.draw.IDrawExec;
import com.lottery.infrastructure.po.Award;
import com.lottery.infrastructure.po.Strategy;
import com.lottery.infrastructure.po.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author Yamon
 * @Create 2023/12/20 9:53
 */
@Service("drawExec")
public class DrawExecImpl extends DrawBase implements IDrawExec {

    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        logger.info("执行策略抽奖开始，strategyId:{}", req.getStrategyId());

        // 获取抽奖策略配置数据
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();

        // 校验和初始化数据
        checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyDetailList);

        // 根据策略方式抽奖
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());
        String awardId = drawAlgorithm.randomDraw(req.getStrategyId(), new ArrayList<>());

        // 获取奖品信息
        Award award = strategyRepository.queryAwardInfo(awardId);

        logger.info("执行策略抽奖完成，中奖用户：{} 奖品ID：{} 奖品名称：{}", req.getuId(), awardId, award.getAwardName());

        // 封装结果
        return new DrawResult(req.getuId(), req.getStrategyId(), awardId, award.getAwardName());
    }
}
