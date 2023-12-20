package com.lottery.domain.strategy.model.vo;

import java.math.BigDecimal;

/**
 * @Author Yamon
 * @Create 2023/12/19 19:18
 * 奖品概率信息， 奖品编号、库存、概率
 */
public class AwardRateInfo {

    // 奖品ID
    private String awardId;

    //中将概率
    private BigDecimal awardRate;

    public AwardRateInfo() {
    }

    public AwardRateInfo(String awardId, BigDecimal awardRate) {
        this.awardId = awardId;
        this.awardRate = awardRate;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }
}
