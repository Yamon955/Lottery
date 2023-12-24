package com.lottery.infrastructure.dao;

import com.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 策略表DAO
 * @Author Yamon
 * @Create 2023/12/20 10:07
 */
@Mapper
public interface IStrategyDao {

    /**
     * 查询策略配置
     * @param strategyId 策略ID
     * @return           策略配置信息
     */
    Strategy queryStrategy(Long strategyId);

    /**
     * 插入策略配置
     * @param req 策略配置
     */
    void insert(Strategy req);
}
