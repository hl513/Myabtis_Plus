package com.xxx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.pojo.Orders;

/**
 * @author HePeng
 * .@date  2022/10/25 20:38
 */
public interface OrdersMappers extends BaseMapper<Orders> {

    /*多表查询 分页查询*/
    IPage<Orders> findAllOrders(Page<Orders> page);

}
