package com.xxx.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.pojo.Orders;
import com.xxx.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * 继承该类  可以实现基础的 crud
 */
public interface UserMapper extends BaseMapper<User> {

    /*自定义sql*/
    User findMyUser(Long id);

    /*自定义方法结合条件构造器 添加 Wrapper 表示 结合条件构造器
    BaseMapper接口里面的 selectList()方法 进行仿写
    * List<T> selectList(@Param("ew") Wrapper<T> queryWrapper);
    Constants.WRAPPER  = "ew"  属于枚举类
     *  */
    User findMyUserByWrapper(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

}