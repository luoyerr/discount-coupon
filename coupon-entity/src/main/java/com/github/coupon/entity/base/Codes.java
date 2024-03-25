package com.github.coupon.entity.base;


import lombok.Getter;

/**
 * 枚举类 - 多例模式
 */
@Getter
public enum Codes {

    SUCC(200, "成功"),
    FAIL(500, "失败"),
    PARAMS_ERROR(409, "参数校验异常"),
    USER_EXISTS(410, "用户名已经存在"),
    LOGIN_FAIL(411, "用户名或者密码错误"),
    USER_NOT_FOUND(412, "用户不存在"),
    CODE_ERROR(413, "验证码不正确"),
    TOKEN_ERROR(414, "Token无效或已过期"),
    IS_FIRENDS(415, "ta已经是你的好友了"),
    IS_REQUEST(416, "已经发送过好友申请了"),
    DATA_ERROR(417, "数据不正确");

    private Integer code;
    private String msg;

    /**
     * 全参构造方法
     * @param code
     * @param msg
     */
    Codes(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
