package com.liu.utils;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * All rights Reserved, Designed By jiexingcloud.
 *
 * @author 刘帅彪
 * @Date2022/9/1 14:32
 * Copyright ©2022 jiexingcloud. All rights reserved.
 * 注意：本内容仅限于结行云创内部传阅，禁止外泄以及用于其他的商业用途。
 */

public class RabbitmqUtils {


    public static Channel getChannel() throws IOException, TimeoutException {
        //      创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
//        设置连接的ip，账号密码
//        不指定端口，默认5672
        factory.setHost("101.43.145.108");
//        设置账号
        factory.setUsername("guest");
        factory.setPassword("guest");
//        创建连接
        Connection connection = factory.newConnection();
//        创建信道
        Channel channel = connection.createChannel();

        return channel;
    }
}
