package com.lottery.infrastructure.dao;

import com.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Yamon
 * @Create 2023/12/20 10:07
 */
@Mapper
public interface IStrategyDao {

    Strategy queryStrategy(Long strategyId);
}
