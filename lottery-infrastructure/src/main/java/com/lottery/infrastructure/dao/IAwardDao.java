package com.lottery.infrastructure.dao;

import com.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 奖品信息表DAO
 * @Author Yamon
 * @Create 2023/12/20 10:26
 */
@Mapper
public interface IAwardDao {

    /**
     * 查询奖品信息
     * @param awardId 奖品ID
     * @return        奖品信息
     */
    Award queryAwardInfo(String awardId);

    /**
     * 插入奖品配置
     * @param awardList 奖品配置
     */
    void insertList(@Param("awardList") List<Award> awardList);
}
