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

}

