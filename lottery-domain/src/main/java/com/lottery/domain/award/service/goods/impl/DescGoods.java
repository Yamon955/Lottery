package com.lottery.domain.award.service.goods.impl;

import com.lottery.common.Constants;
import com.lottery.domain.award.model.req.GoodsReq;
import com.lottery.domain.award.model.res.DistributionRes;
import com.lottery.domain.award.service.goods.DistributionBase;
import com.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @Description 描述类商品，以文字形式展示给用户
 * @Author Yamon
 * @Create 2023/12/22 11:13
 */
@Component
public class DescGoods extends DistributionBase implements IDistributionGoods {

    @Override
    public DistributionRes doDistribution(GoodsReq req) {

        // 模拟描述类奖品发放接口
        logger.info("模拟描述类奖品发放接口 uId：{} awardContent：{}", req.getuId(), req.getAwardContent());

        // 更新用户领奖结果
        super.updateUserAwardState(req.getuId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.DESC.getCode();
    }
}
