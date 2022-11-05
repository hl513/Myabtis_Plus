package com.xxx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.mapper.OrdersMappers;
import com.xxx.mapper.UserMapper;
import com.xxx.pojo.Orders;
import com.xxx.pojo.User;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HePeng
 * .@date  2022/10/25 21:06
 * 这样就不需要注入 UserMapper
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Resource
    private OrdersMappers ordersMapper;

    @Override
    public User test() {
        /*获取当前类的  xxxMapper  */
        UserMapper userMapper = getBaseMapper();
//        List<Orders> orders = ordersMapper.selectList(null);
        User user = userMapper.selectById(2);

        return user;
    }

}
