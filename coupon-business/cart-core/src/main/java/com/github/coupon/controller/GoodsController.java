package com.github.coupon.controller;


import com.github.coupon.entity.base.R;
import com.github.coupon.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 商品表(Goods)表控制层
 *
 * @author 小帅
 * @since 2024-03-24 22:37:41
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public R getGoodsList() {
        return R.succ(goodsService.list());
    }
}

