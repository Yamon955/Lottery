package com.lottery.domain.strategy.service.draw;

import com.lottery.domain.strategy.model.req.DrawReq;
import com.lottery.domain.strategy.model.res.DrawResult;

/**
 * @Author Yamon
 * @Create 2023/12/19 23:12
 */
public interface IDrawExec {

    DrawResult doDrawExec(DrawReq req);
}
