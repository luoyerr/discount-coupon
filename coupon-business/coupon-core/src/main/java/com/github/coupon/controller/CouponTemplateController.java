package com.github.coupon.controller;

import com.github.coupon.entity.base.R;
import com.github.coupon.entity.po.CouponTemplate;
import com.github.coupon.service.CouponTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小帅
 * @version 1.0
 * @date 2024/3/27 19:03
 */
@RestController
@RequestMapping("/coupon/template")
public class CouponTemplateController {
    @Autowired
    private CouponTemplateService couponTemplateService;

    /**
     * 新增优惠券模版
     * @return
     */
    @PostMapping("/insert")
    public R insert(@RequestBody CouponTemplate couponTemplate) {
        System.out.println("新增优惠券模版" + couponTemplate);
        couponTemplateService.save(couponTemplate);
        return R.succ();
    }
}
