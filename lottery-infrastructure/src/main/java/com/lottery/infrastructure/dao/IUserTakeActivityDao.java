package com.lottery.infrastructure.dao;

import com.lottery.infrastructure.po.UserTakeActivity;
import com.yamon.middleware.db.router.annotation.DBRouter;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 用户领取活动表DAO
 * @Author Yamon
 * @Create 2023/12/29 10:30
 */
@Mapper
public interface IUserTakeActivityDao {

     /**
     * 插入用户领取活动信息
     *
     * @param userTakeActivity 入参
     */
    @DBRouter(key = "uId")
    void insert(UserTakeActivity userTakeActivity);

    /**
     * 查询数据
     * @param uId 用户ID
     * @return 用户领取活动信息
     */
    @DBRouter
    UserTakeActivity queryUserTakeActivityByUId(String uId);
}
