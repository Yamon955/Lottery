package com.lottery.rpc.res;

import com.lottery.common.Result;
import com.lottery.rpc.dto.ActivityDto;

import java.io.Serializable;

/**
 * @Author Yamon
 * @Create 2023/12/15 20:52
 * Description:
 */
public class ActivityRes implements Serializable {
    private Result result;
    private ActivityDto activity;

    public ActivityRes() {
    }

    public ActivityRes(Result result) {
        this.result = result;
    }

    public ActivityRes(Result result, ActivityDto activity) {
        this.result = result;
        this.activity = activity;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ActivityDto getActivity() {
        return activity;
    }

    public void setActivity(ActivityDto activity) {
        this.activity = activity;
    }
}
