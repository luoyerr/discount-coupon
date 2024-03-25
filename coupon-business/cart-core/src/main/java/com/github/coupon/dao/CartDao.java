package com.github.coupon.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.github.coupon.entity.po.Cart;
import com.github.coupon.entity.vo.CartInfoVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 购物车表(Cart)表数据库访问层
 *
 * @author 小帅
 * @since 2024-03-24 22:37:40
 */
public interface CartDao extends BaseMapper<Cart> {
    @Select("""
            select c.id, c.gid, g.title, g.image, g.price, c.number 
            from cart c join goods g on c.gid = g.id where c.uid = #{uid}
""")
    List<CartInfoVo> queryMyCarts(Integer uid);

}

