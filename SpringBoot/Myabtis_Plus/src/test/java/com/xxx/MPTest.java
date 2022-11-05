package com.xxx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.xxx.mapper.UserMapper;
import com.xxx.pojo.Orders;
import com.xxx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@SpringBootTest
public class MPTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryList(){
        System.out.println(userMapper.selectList(null));
    }

    /**
     * 设置主键生成策略
     * 插入用户
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("三更草堂222");
        user.setPassword("7777");
        int r = userMapper.insert(user);
        System.out.println(r);
    }

    /**
     * 删除用户
     */
    @Test
    public void testDelete(){
        List<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(6);
        ids.add(7);
        int i = userMapper.deleteBatchIds(ids);
        System.out.println(i);
    }

    /**
     * 根据id进行删除
     */
    @Test
    public void testDeleteById(){
        int i = userMapper.deleteById(4);
        System.out.println(i);
    }

    /**
     * 删除一个集合
     */
    @Test
    public void testDeleteByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","提姆");
        map.put("age",22);
        int i = userMapper.deleteByMap(map);
        System.out.println(i);
    }

    /**
     * 数据的更新操作
     */
    @Test
    public void testUpdate(){
        //把id为2的用户的年龄改为14
        User user = new User();
        user.setId(2L);
        user.setAge(14);
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    /**
     * QueryWrapper的方法
     */
    @Test
    public void testWrapper(){
        // 由于Wrapper是抽象类，不能直接创建实例，所以只能通过子类来实现
        QueryWrapper queryWrapper = new QueryWrapper<>();
        // 添加 筛选条件  第一个参数为列名，第二个参数为具体的值
        queryWrapper.gt("age",18);
        queryWrapper.eq("user_name","timu");
        queryWrapper.in("id",1,2,3);
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }



    @Test
    public void testWrapper02(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("id", 1, 2, 3);
        /*在某个访问的值都满足*/
        wrapper.between("age",12,29);
        /*模糊查询*/
        wrapper.like("address","山");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /**
     * 排序的方法
     */
    @Test
    public void testWrapper03(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",1,2,3);
        queryWrapper.gt("age", 10);
        /*进行什么样的排序：升序还是降序*/
        queryWrapper.orderByDesc("age");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    /**
     * 查询要显示的列
     * select()方法
     */
    @Test
    public void testSelect01(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","user_name");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /**
     * 匿名内部类的写法
     * 只显示一个列
     */
    @Test
    public void testSelect02(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(User.class, new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return "user_name".equals(tableFieldInfo.getColumn());
            }
        });
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /**
     * lamda表达式的写法
     * 不包含某个列
     */
    @Test
    public void testSelect03(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(new User());
        queryWrapper.select(new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return !"address".equals(tableFieldInfo.getColumn());
            }
        });
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

}