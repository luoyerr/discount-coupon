package com.github.coupon.entity;


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
public class Cart implements Serializable {
    //id
    private Integer id;
    //商品id
    private Integer gid;
    //用户id
    private Integer uid;
    //商品数量
    private Integer number;
    //商品价格小计
    private Double xiaoji;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //状态：0-正常，1-下架
    private Integer status;
    //删除标志：0-未删除，1-已删除
    private Integer delFlag;


}

