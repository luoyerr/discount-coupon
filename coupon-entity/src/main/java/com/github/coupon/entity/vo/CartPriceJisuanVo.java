package com.github.coupon.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 小帅
 * @version 1.0
 * @date 2024/3/25 21:45
 */
@Data
public class CartPriceJisuanVo {
    // 被选中的购物车ID集合
    private List<Integer> cids;

    // 选择使用优惠卷的ID
    private Integer couponId;
}
