package com.github.coupon.entity.po;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

/**
 * 优惠券模板实体类
 *
 * 模版的基本信息
 * 模版类型 - 0: 使用限制模版 1:优惠券规则模版
 *
 * groovy 脚本
 *  动态表单项
 *      - 表单项的标签
 *      - 表单项的Home（提交数据的key）
 *      - 表单项输入的类型 (1-文本框 2-下拉框 3-单选框)
 * @author 小帅
 * @version 1.0
 * @date 2024/3/26 20:31
 */
@Data
@Document(collection = "coupon_template")
public class CouponTemplate {

    @MongoId
    private String id;
    // 模版名称
    private String templateName;
    // 模版类型 0 限制模版 1 优惠规则模版
    private Integer templateType;
    // 模版对应的脚本内容
    private String script;
    //模版中的多个表单项
    private List<FormItem> formItems;
    /**
     * 代表一个表单项
     */

    @Data
    public static class FormItem{
        // 表单项的标签
        private String itemTitle;
        //表单项的name
        private String itemName;
        //表单项的类型
        private Integer itemType;

    }
}
