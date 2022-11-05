package com.xxx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.pojo.User;
import com.xxx.service.UserService;
import com.xxx.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author HePeng
 * .@date  2022/10/25 21:12
 */
@SpringBootTest
public class ServiceTest {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 查询所有记录
     */
    @Test
    public void testService(){
        List<User> list = userService.list();
        System.out.println(list);
    }

    /**
     * 查询分页
     */
    @Test
    public void testPage(){
        List<User> list = userService.list();
        Page<User> page = new Page<>();
        // 设置每页大小
        page.setSize(2);
        // 设置当前页码
        page.setCurrent(1);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("id",1);
        userService.page(page,wrapper);

    }
    @Test
    public void testMyMethod(){
        User test = userService.test();
        System.out.println(test);
    }

}
