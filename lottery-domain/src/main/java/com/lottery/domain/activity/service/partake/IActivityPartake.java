package com.lottery.domain.activity.service.partake;

import com.lottery.domain.activity.model.req.PartakeReq;
import com.lottery.domain.activity.model.res.PartakeResult;

/**
 * @Description 抽奖活动参与接口
 * @Author Yamon
 * @Create 2023/12/30 15:53
 */
public interface IActivityPartake {

    /**
     * 参与活动
     * @param req 入参
     * @return 领取结果
     */
    PartakeResult doPartake(PartakeReq req);
}
