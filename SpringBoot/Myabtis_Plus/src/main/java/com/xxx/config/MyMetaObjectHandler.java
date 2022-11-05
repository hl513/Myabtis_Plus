package com.xxx.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

/**
 * @author HePeng
 * .@date  2022/10/25 21:51
 * 自定义填充处理器
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入时自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        /*第一个参数为 我们要填充的字段  第二个参数为 填充的值 第三个值为  metaObject */
        this.setFieldValByName("createTime", LocalDateTime.now(),metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(),metaObject);
    }

    /**
     * 修改时自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",LocalDateTime.now(),metaObject);
    }
}
