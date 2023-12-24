package com.lottery.domain.award.service.factory;

import com.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @Description 配送商品简单工厂，提供获取配送服务
 * @Author Yamon
 * @Create 2023/12/22 11:40
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig{

    public IDistributionGoods getDistributionGoodsService(Integer awardType){
        return goodsMap.get(awardType);
    }
}
