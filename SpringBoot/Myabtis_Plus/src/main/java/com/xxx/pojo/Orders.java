package com.xxx.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("orders")
public class Orders {

    private Long id;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 更新时间
     * 自动填充 创建和修改时自动填充
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 创建时间
     * 自动填充  在创建的时候进行填充
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 版本
     * 乐观锁的应用
         * 取出记录时，获取当前 version
         * 更新时，带上这个 version
         * 执行更新时， set version = newVersion where version = oldVersion
         * 如果 version 不对，就更新失败
     */
    @Version
    private Integer version;

    /**
     * 逻辑删除标识,0-未删除,1-已删除
     *
     *. @TableLogic 逻辑删除注解
     */
    @TableLogic
    private Integer delFlag;

    /*用于多表分页查询*/
/*    @TableField("user_name")
    private String userName;*/


}