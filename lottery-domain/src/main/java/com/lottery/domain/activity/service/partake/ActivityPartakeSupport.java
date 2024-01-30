package com.lottery.domain.activity.service.partake;

import com.lottery.domain.activity.model.req.PartakeReq;
import com.lottery.domain.activity.model.vo.ActivityBillVO;
import com.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @Description 活动领取模操作，一些通用的数据服务
 * @Author Yamon
 * @Create 2023/12/30 15:53
 */
public class ActivityPartakeSupport {

    @Resource
    protected IActivityRepository activityRepository;

    protected ActivityBillVO queryActivityBill(PartakeReq req){
        return activityRepository.queryActivityBill(req);
    }
}
