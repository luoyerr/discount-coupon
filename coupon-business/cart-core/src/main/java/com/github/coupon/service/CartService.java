package com.github.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.coupon.entity.po.Cart;
import com.github.coupon.entity.vo.CartInfoVo;
import com.github.coupon.entity.vo.CartPriceJisuanVo;
import com.github.coupon.entity.vo.CartPriceVo;

import java.util.List;

/**
 * 购物车表(Cart)表服务接口
 *
 * @author 小帅
 * @since 2024-03-24 22:37:40
 */
public interface CartService extends IService<Cart> {

    List<CartInfoVo> queryMyCarts(Integer uid);

    CartPriceVo cartAllPrice(CartPriceJisuanVo cartPriceJisuanVo);
}

