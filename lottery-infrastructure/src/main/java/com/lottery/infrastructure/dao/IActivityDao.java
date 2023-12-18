package com.lottery.infrastructure.dao;

import com.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Yamon
 * @Create 2023/12/15 21:16
 */
@Mapper
public interface IActivityDao {

    void insert(Activity req);

    Activity queryActivityById(Long activityId);

}
