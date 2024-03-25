package com.github.coupon.controller;


import com.github.coupon.entity.po.Cart;
import com.github.coupon.entity.base.R;
import com.github.coupon.entity.po.Goods;
import com.github.coupon.entity.vo.CartPriceJisuanVo;
import com.github.coupon.entity.vo.CartPriceVo;
import com.github.coupon.service.CartService;
import com.github.coupon.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


/**
 * 购物车表(Cart)表控制层
 *
 * @author 小帅
 * @since 2024-03-24 22:37:40
 */
@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private CartService cartService;


    /**
     * 添加购物车
     * @param cart
     * @return
     */
    @PostMapping("/insert")
    public R insert(@RequestBody Cart cart) {
        // 模拟一个用户id
        cart.setUid(1);
        cartService.save(cart);
        return R.succ();
    }

    /**
     * 查询我的购物车
     * @return
     */
    @GetMapping("/mylist")
    public R mylist( Integer uid) {
        return R.succ(cartService.queryMyCarts(uid));
    }

    /**
     * 计算购物车总价
     * @param cartPriceJisuanVo
     * @return
     */
    @PostMapping("/cartAllPrice")
    public R cartAllPrice(@RequestBody CartPriceJisuanVo cartPriceJisuanVo) {
        System.out.println("计算购物车总价 : " + cartPriceJisuanVo);
        CartPriceVo cartPriceVo = cartService.cartAllPrice(cartPriceJisuanVo);
        return R.succ(cartPriceVo);
    }
}

