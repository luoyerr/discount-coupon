package com.github.coupon.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 小帅
 * @version 1.0
 * @date 2024/3/25 16:41
 */
@Data
@Accessors(chain = true)
public class CartInfoVo {

    // 购物车 ID
    private Integer id;
    // 商品ID
    private Integer gid;
    // 商品标题
    private String title;
    // 商品封面
    private String image;
    //  商品价格
    private Double price;
    // 商品数量
    private Integer number;
    // 价格小计
    private Double xiaoji;
}
