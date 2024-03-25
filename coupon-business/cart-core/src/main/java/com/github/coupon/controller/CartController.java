package com.github.coupon.controller;


import com.github.coupon.entity.Cart;
import com.github.coupon.entity.base.R;
import com.github.coupon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
        System.out.println(" --> " +  cart);
        // 模拟一个用户id
        cart.setUid(1);
        cartService.save(cart);
        return R.succ();
    }
}

