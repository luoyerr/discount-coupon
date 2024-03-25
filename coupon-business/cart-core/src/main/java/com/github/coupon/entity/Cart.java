package com.github.coupon.entity;


import com.github.coupon.entity.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物车表(Cart)表实体类
 *
 * @author 小帅
 * @since 2024-03-24 22:37:40
 */
@Data
@Accessors(chain = true)
public class Cart extends BaseEntity implements Serializable {
    //商品id
    private Integer gid;
    //用户id
    private Integer uid;
    //商品数量
    private Integer number;
    //商品价格小计
    private Double xiaoji;

}

