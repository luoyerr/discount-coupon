package com.github.coupon.entity.po;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品表(Goods)表实体类
 *
 * @author 小帅
 * @since 2024-03-24 22:37:41
 */
@Data
@Accessors(chain = true)
public class Goods implements Serializable {
    //id
    private Integer id;
    //品牌id
    private Integer brandid;
    //商品标题
    private String title;
    //封面
    private String image;
    //商品价格
    private Double price;
    //库存
    private Integer save;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //状态：0-正常，1-下架
    private Integer status;
    //删除标志：0-未删除，1-已删除
    private Integer delFlag;
    //分类id
    private Integer typeid;


}

