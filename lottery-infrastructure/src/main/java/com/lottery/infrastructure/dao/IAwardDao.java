package com.lottery.infrastructure.dao;

import com.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Yamon
 * @Create 2023/12/20 10:26
 */
@Mapper
public interface IAwardDao {

    Award queryAwardInfo(String awardId);
}
