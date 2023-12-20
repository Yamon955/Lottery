package com.lottery.infrastructure.dao;

import com.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Yamon
 * @Create 2023/12/20 10:15
 */
@Mapper
public interface IStrategyDetailDao {

    List<StrategyDetail> queryStrategyDetailList(Long strategyId);
}
