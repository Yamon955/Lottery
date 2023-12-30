package com.lottery.infrastructure.dao;

import com.lottery.infrastructure.po.UserStrategyExport;
import com.yamon.middleware.db.router.annotation.DBRouter;
import com.yamon.middleware.db.router.annotation.DBRouterStrategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 用户策略计算结果表DAO
 * @Author Yamon
 * @Create 2023/12/29 10:30
 */
@Mapper
@DBRouterStrategy(splitTable = true)  // 表示进行分表操作
public interface IUserStrategyExportDao {
    /**
     * 新增数据
     * @param userStrategyExport 用户策略
     */
    @DBRouter(key = "uId")  //指定路由字段为 uId，如果未指定，默认为uId(配置文件给出)
    void insert(UserStrategyExport userStrategyExport);

    /**
     * 查询数据
     * @param uId 用户ID
     * @return 用户策略
     */
    @DBRouter
    UserStrategyExport queryUserStrategyExportByUId(String uId);
}
