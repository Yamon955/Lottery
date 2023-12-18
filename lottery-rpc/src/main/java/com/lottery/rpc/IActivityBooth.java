package com.lottery.rpc;

import com.lottery.rpc.req.ActivityReq;
import com.lottery.rpc.res.ActivityRes;

/**
 * @Author Yamon
 * @Create 2023/12/15 20:50
 * Description:
 *      活动展台
 *          1. 创建活动
 *          2. 更新活动
 *          3. 查询活动
 */
public interface IActivityBooth {
    ActivityRes queryActivityById(ActivityReq req);
}
