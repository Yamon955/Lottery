package com.lottery.domain.award.service.factory;

import com.lottery.common.Constants;
import com.lottery.domain.award.service.goods.IDistributionGoods;
import com.lottery.domain.award.service.goods.impl.CouponGoods;
import com.lottery.domain.award.service.goods.impl.DescGoods;
import com.lottery.domain.award.service.goods.impl.PhysicalGoods;
import com.lottery.domain.award.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 各类发奖奖品配置类
 *      把四种奖品的发奖，放到一个统一的配置文件类 Map 中，便于通过 AwardType 获取相应的对象，减少 if...else 的使用。
 * @Author Yamon
 * @Create 2023/12/22 11:36
 */
public class GoodsConfig {

    // 奖品发放策略组
    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private DescGoods descGoods;

    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @Resource
    private CouponGoods couponGoods;

    @Resource
    private PhysicalGoods physicalGoods;

    @PostConstruct
    public void init(){
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
    }
}
