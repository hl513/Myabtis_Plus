package com.xxx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.mapper.OrdersMappers;
import com.xxx.pojo.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author HePeng
 * .@date  2022/10/25 20:39
 */
@SpringBootTest
public class TestOrdes {

    @Autowired
    private OrdersMappers ordersMapper;

    @Test
    public void testOrdersPage(){
        Page<Orders> page = new Page<>();
        //设置每页大小
        page.setSize(2);
        //设置当前页码
        page.setCurrent(1);
        ordersMapper.findAllOrders(page);
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
    }

    /**
     * 测试逻辑删除
     * 实际执行的时 修改语句  将 del_flag设置为 1
     */
    @Test
    public void testDelete02(){
        ordersMapper.deleteById(99);
    }

    /**
     * 乐观锁的测试
     */
    @Test
    public void testVersion(){
        //查询id为3的数据
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",4);
        Orders orders = ordersMapper.selectOne(queryWrapper);
        //对id为3的数据进行更新  把price修改为88
        orders.setPrice(88);
        ordersMapper.updateById(orders);
    }

}
