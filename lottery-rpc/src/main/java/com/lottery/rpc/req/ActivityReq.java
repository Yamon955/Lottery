package com.lottery.rpc.req;

import java.io.Serializable;

/**
 * @Author Yamon
 * @Create 2023/12/15 20:52
 * Description:
 */
public class ActivityReq implements Serializable {
    private Long activityId;

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getActivityId() {
        return activityId;
    }

}
