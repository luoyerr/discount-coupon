package com.github.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.coupon.dao.CartDao;
import com.github.coupon.entity.Cart;
import com.github.coupon.service.CartService;
import org.springframework.stereotype.Service;

/**
 * 购物车表(Cart)表服务实现类
 *
 * @author 小帅
 * @since 2024-03-24 22:37:41
 */
@Service("cartService")
public class CartServiceImpl extends ServiceImpl<CartDao, Cart> implements CartService {
    @Override
    public boolean save(Cart entity) {
        // 判断当前用户的购物车中是否已经存在该商品
        Cart cart =  this.query()
                .eq("gid" ,entity.getGid())
                .eq("uid",entity.getUid())
                .one();

        if (cart == null) {
            // 没有添加过这个商品
            entity.setNumber(1);
            entity.setXiaoji(80.00);
            // 保存购物车信息
            return super.save(entity);
        }
        // 已经添加过该商品
        cart.setNumber(cart.getNumber() + 1);
        // 查询购物车的信息
        this.updateById(cart);
        return true;
    }
}

