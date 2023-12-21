package com.lottery.domain.strategy.repository;

import com.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.lottery.infrastructure.po.Award;

import java.util.List;

/**
 * @Description 策略表仓储服务
 * @Author Yamon
 * @Create 2023/12/20 9:56
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     * @param strategyId 策略ID
     * @param awardId 奖品ID
     * @return 扣减结果
     */
    boolean deductStock(Long strategyId, String awardId);
}
