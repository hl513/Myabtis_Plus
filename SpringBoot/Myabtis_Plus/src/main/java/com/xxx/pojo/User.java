package com.xxx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// @TableName("tb_user") 当表名和实体类的名，不一样时，需要加注解
public class User {

    /**
     * 设置主键自动增长则可以如下设置
     * Auto  数据库ID自增   依赖于数据要看
     * NONE   未设置主键类型 ，若在代码中没有手动设置主键，则会根据 主键的全局策略 自动生成
     * ASSIGN_ID    当没有手动设置主键  即实体类中的主键属性位空时，才会自动填充,使用雪花算法
     * ASSIGN_UUID     当实体类的主键属性为空时，才会自动填充，使用UUID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String address;

    // 当表中的一个列名和实体类中的属性名不一样时  可以使用如下设置
  /*  @TableField("address")
    private String addressStr;*/

}