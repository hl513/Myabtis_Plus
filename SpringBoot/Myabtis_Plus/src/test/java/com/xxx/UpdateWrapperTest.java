package com.xxx;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xxx.mapper.UserMapper;
import com.xxx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author HePeng
 * .@date  2022/10/25 19:26
 */
@SpringBootTest
public class UpdateWrapperTest {

    @Resource
    private UserMapper userMapper;

    /**
     * 把id为大于1  的用户年龄修改为 99
     * set() 方法 设置更新时的一些字段
     */
    @Test
    public void testUpdateWrapper(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.notIn("id",1);
        updateWrapper.gt("id",1);
        updateWrapper.set("age",19);
        userMapper.update(null,updateWrapper);
    }

    /**
     * lamda条件构造器
     * 没使用之前的
     */
    @Test
    public void testLambdaWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.gt("age",18);
        queryWrapper.eq("address","狐山");
        List<User> users = userMapper.selectList(queryWrapper);
    }

    /**
     * lamda条件构造器
     *  使用之后的
     */
    @Test
    public void testLambdaWrapper2(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 方法引用的形式
        queryWrapper.gt(User::getAge,18);
        queryWrapper.eq(User::getAddress,"狐山");
        List<User> users = userMapper.selectList(queryWrapper);
    }



}
