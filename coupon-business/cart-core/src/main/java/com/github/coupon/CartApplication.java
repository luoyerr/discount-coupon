package com.github.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 小帅
 * @version 1.0
 * @date 2024/3/24 20:38
 */
@SpringBootApplication
@MapperScan("com.github.coupon.**.dao")
public class CartApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class,args);
    }
}
