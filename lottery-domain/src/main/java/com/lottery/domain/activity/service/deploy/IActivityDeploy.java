package com.lottery.domain.activity.service.deploy;

import com.lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * @Description 部署活动配置接口
 * @Author Yamon
 * @Create 2023/12/24 14:30
 */
public interface IActivityDeploy {

    /**
     * 创建活动信息
     * @param req 活动配置信息
     */
    void createActivity(ActivityConfigReq req);

    /**
     * 修改活动信息
     * @param req 活动配置信息
     */
    void updateActivity(ActivityConfigReq req);
}
