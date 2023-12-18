package com.lottery.interfaces;

import com.lottery.common.Constants;
import com.lottery.rpc.IActivityBooth;
import com.lottery.common.Result;
import com.lottery.infrastructure.dao.IActivityDao;
import com.lottery.rpc.dto.ActivityDto;
import com.lottery.infrastructure.po.Activity;
import com.lottery.rpc.req.ActivityReq;
import com.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @Author Yamon
 * @Create 2023/12/15 21:22
 */
@Service //这个注解是来自于 Dubbo 的 org.apache.dubbo.config.annotation.Service，也就是这个包下含有此注解配置的类可以被 Dubbo 管理
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao iActivityDao;
    @Override
    public ActivityRes queryActivityById(ActivityReq req) {
        Activity activity = iActivityDao.queryActivityById(req.getActivityId());
        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);

    }
}
