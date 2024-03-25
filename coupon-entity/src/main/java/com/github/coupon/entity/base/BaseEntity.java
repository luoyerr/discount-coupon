package com.github.coupon.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;
import lombok.Data;

/**
 * @author 小帅
 * @version 1.0
 * @date 2024/3/24 21:54
 */

@Data
public class BaseEntity {
    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //创建时间
    private Date createTime = new Date();
    //修改时间
    private Date updateTime = new Date();
    //状态
    private Integer status = 0;
    //删除标识
    private Integer delFlag = 0;
}