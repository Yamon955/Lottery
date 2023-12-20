package com.lottery.domain.strategy.repository;

import com.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.lottery.infrastructure.po.Award;

/**
 * @Author Yamon
 * @Create 2023/12/20 9:56
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);
}
