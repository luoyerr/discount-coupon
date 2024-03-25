package com.github.coupon.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 小帅
 * @version 1.0
 * @date 2024/3/25 21:28
 */
@Accessors(chain = true)
@Data
public class CartPriceVo {
    // 总价格
    private  Double allPrice;
    // 实际价格（减去优惠券后的价格）
    private  Double shijiPrice;
    // 优惠券抵扣的价格
    private Double  youhuiPrice;
}
