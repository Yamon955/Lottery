package com.lottery.domain.strategy.repository.impl;

import com.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.lottery.domain.strategy.repository.IStrategyRepository;
import com.lottery.infrastructure.dao.IAwardDao;
import com.lottery.infrastructure.dao.IStrategyDao;
import com.lottery.infrastructure.dao.IStrategyDetailDao;
import com.lottery.infrastructure.po.Award;
import com.lottery.infrastructure.po.Strategy;
import com.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Yamon
 * @Create 2023/12/20 10:04
 */
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetailList);
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }
}
