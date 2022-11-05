package com.xxx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.pojo.User;

/**
 * @author HePeng
 * .@date  2022/10/25 21:05
 * mybatisPlus提供的 IService  同样有许多封装好的方法
 */
public interface UserService extends IService<User> {

    /*自定义方法*/
    User test();

}
