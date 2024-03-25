package com.github.coupon.exception;

/**
 * @author 小帅
 * @version 1.0
 * @date 2024/3/24 21:44
 */

import com.github.coupon.entity.base.Codes;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 自定义的异常信息
 */
@Getter
@AllArgsConstructor
public class ServiceException extends RuntimeException{

    private Codes codes;
}