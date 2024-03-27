package com.github.coupon.service.impl;

import com.github.coupon.entity.base.Codes;
import com.github.coupon.entity.po.CouponTemplate;
import com.github.coupon.exception.ServiceException;
import com.github.coupon.service.CouponTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


/**
 * @author 小帅
 * @version 1.0
 * @date 2024/3/27 19:25
 */
@Service
public class CouponTemplateServiceImpl implements CouponTemplateService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public int save(CouponTemplate couponTemplate) {
        CouponTemplate templateName = mongoTemplate.findOne(
                new Query(Criteria.where("templateName")
                        .is(couponTemplate.getTemplateName())),
                CouponTemplate.class
        );

        if (templateName != null) {
            // 如果模版已经存在 则抛出异常
            throw new ServiceException(Codes.FAIL);
        }
        // 查询当前的模版名称 如果存在则不能重复添加
        mongoTemplate.insert(couponTemplate);
        return 1;
    }
}
