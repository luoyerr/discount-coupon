package com.github.coupon.exception;

import com.github.coupon.entity.base.Codes;
import com.github.coupon.entity.base.R;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     * Throwable
     *  - Exception
     *  - Error
     */
    @ExceptionHandler(Throwable.class)
    public R globalExceptionHandler(Throwable e){
        //记录日志
        log.error("捕获到全局异常信息！", e);
        return R.fail(Codes.FAIL);
    }

    /**
     * 自定义业务异常的统一处理
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public R serviceExceptionHandler(ServiceException e){
        Codes codes = e.getCodes();
        return R.fail(codes);
    }

    /**
     * 参数校验异常
     * @return
     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public R requestBodyParamException(MethodArgumentNotValidException e){
////        List<String> errors = new ArrayList<>();
////        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
////        for (ObjectError error : allErrors) {
////            String errorMessage = error.getDefaultMessage();
////            errors.add(errorMessage);
////        }
//
//        //Stream流
//        List<String> errors = e.getBindingResult().getAllErrors()
//                .stream()
//                .map(objectError -> objectError.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        return R.fail(Codes.PARAMS_ERROR, errors);
//    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public R paramsValidateException(ConstraintViolationException e){
//        List<String> message = e.getConstraintViolations().stream()
//                .map(constraintViolation -> constraintViolation.getMessage())
//                .collect(Collectors.toList());
//        return R.fail(Codes.PARAMS_ERROR, message);
//    }
}