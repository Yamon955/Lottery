package com.lottery.domain.strategy.service.draw;

import com.lottery.domain.strategy.model.req.DrawReq;
import com.lottery.domain.strategy.model.res.DrawResult;

/**
 * @Description 抽奖执行接口
 * @Author Yamon
 * @Create 2023/12/19 23:12
 */
public interface IDrawExec {

    /**
     * 抽奖方法
     * @param req 抽奖参数：用户ID、策略ID
     * @return
     */
    DrawResult doDrawExec(DrawReq req);
}
