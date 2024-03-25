package com.github.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.coupon.dao.CartDao;
import com.github.coupon.entity.po.Cart;
import com.github.coupon.entity.po.Goods;
import com.github.coupon.entity.vo.CartInfoVo;
import com.github.coupon.entity.vo.CartPriceJisuanVo;
import com.github.coupon.entity.vo.CartPriceVo;
import com.github.coupon.service.CartService;
import com.github.coupon.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 购物车表(Cart)表服务实现类
 *
 * @author 小帅
 * @since 2024-03-24 22:37:41
 */
@Service("cartService")
public class CartServiceImpl extends ServiceImpl<CartDao, Cart> implements CartService {


    @Autowired
    private GoodsService goodsService;
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


    /**
     * 查询我的购物车 同时关联查询商品信息1
     * @param uid
     * @return
     */
    @Override
    public List<CartInfoVo> queryMyCarts(Integer uid) {

        List<CartInfoVo> cartInfoVos = getBaseMapper().queryMyCarts(uid);

        // 动态计算小计
        for (CartInfoVo cartInfoVo : cartInfoVos ) {
            Double xiaoji = BigDecimal.valueOf(cartInfoVo.getPrice())
                    .multiply(BigDecimal.valueOf(cartInfoVo.getNumber()))
                    .setScale(2, RoundingMode.DOWN)
                    .doubleValue();
            cartInfoVo.setXiaoji(xiaoji);
        }
        return cartInfoVos;
    }

    /**
     * 计算总价
     * @param
     * @return
     */
    @Override
    public CartPriceVo cartAllPrice(CartPriceJisuanVo cartPriceJisuanVo) {
        // 根据购物车ID 把购物车查询出来
        List<Integer> cids = cartPriceJisuanVo.getCids();

        // 原始总价
        Double allPrice = 0.0;
        // 循环购物车id集合·
        for (Integer cid : cids) {
            // 根据购物车id查询购物车
            Cart cart = this.getById(cid);
            // 根据购物车商品id 查询商品信息
            Goods goods = goodsService.getById(cart.getGid());
            // 计算小计
            BigDecimal xiaoji = BigDecimal.valueOf(goods.getPrice())
                    .multiply(BigDecimal.valueOf(cart.getNumber()))
                    .setScale(2, RoundingMode.DOWN);
            // 每个购物车小计都进行累加
            allPrice = BigDecimal.valueOf(allPrice)
                    .add(xiaoji)
                    .setScale(2,RoundingMode.DOWN)
                    .doubleValue();
        }
        // TODO 通过优惠券进行优惠计算
        CartPriceVo cartPriceVo = new CartPriceVo();
        // 设置原始总价
        cartPriceVo.setAllPrice(allPrice);
        return cartPriceVo;
    }
}

