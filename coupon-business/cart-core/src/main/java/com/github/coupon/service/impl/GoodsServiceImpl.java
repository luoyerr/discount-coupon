package com.github.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.coupon.dao.GoodsDao;
import com.github.coupon.entity.po.Goods;
import com.github.coupon.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * 商品表(Goods)表服务实现类
 *
 * @author 小帅
 * @since 2024-03-24 22:37:41
 */
@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, Goods> implements GoodsService {

}

