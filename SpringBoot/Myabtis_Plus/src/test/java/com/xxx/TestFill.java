package com.xxx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.xxx.mapper.OrdersMappers;
import com.xxx.pojo.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author HePeng
 * .@date  2022/10/25 21:55
 * 测试自动填充
 */
@SpringBootTest
public class TestFill {

    @Resource
    private OrdersMappers ordersMappers;

    @Test
    public void testFill(){
        Orders orders = new Orders();
        orders.setId(4L);
        orders.setPrice(9000);
        orders.setRemark("备注");
        orders.setCreateTime(LocalDateTime.now());
        orders.setVersion(1);
        orders.setDelFlag(0);

        // 更新操作
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("id",99);
        ordersMappers.update(orders,wrapper);

        // 插入操作
//        ordersMappers.insert(orders);

    }

}
