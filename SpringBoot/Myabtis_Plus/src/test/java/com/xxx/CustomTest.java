package com.xxx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.mapper.UserMapper;
import com.xxx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

/**
 * @author HePeng
 * .@date  2022/10/25 19:56
 */
@SpringBootTest
public class CustomTest {

    @Resource
    private UserMapper userMapper;

    /**
     * 自定义方法 根据条件进行查询
     */
    @Test
    public void testMethod(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("id",1);
        User user = userMapper.findMyUser(1L);
        System.out.println(user);
    }

    /**
     * 自定义方法使用条件构造器进行构造
     */
    @Test
    public void testMyMethod(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",1);
        wrapper.eq("address","山东");
        User user = userMapper.findMyUserByWrapper(wrapper);
        System.out.println(user);
    }


}
