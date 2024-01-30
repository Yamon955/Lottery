package com.lottery.domain.activity.model.res;

import com.lottery.common.Result;

/**
 * @Description 活动参与结果
 * @Author Yamon
 * @Create 2023/12/30 15:56
 */
public class PartakeResult extends Result {

    /**
     * 策略ID
     */
    private Long strategyId;

    public PartakeResult(String code, String info) {
        super(code, info);
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
}
