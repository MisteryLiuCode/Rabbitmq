package com.liu;

import com.liu.utils.RabbitmqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * All rights Reserved, Designed By jiexingcloud.
 *
 * @author 刘帅彪
 * @Date2022/9/1 14:04
 * Copyright ©2022 jiexingcloud. All rights reserved.
 * 注意：本内容仅限于结行云创内部传阅，禁止外泄以及用于其他的商业用途。
 */

public class Consumer {

    private static final String QUEUE_NAME="RabbitmqName";

    public static void main(String[] args) throws IOException, TimeoutException {

        Channel channel = RabbitmqUtils.getChannel();

//        接收消息的回调
        DeliverCallback deliverCallback=(consumerTag,message)->{
            System.out.println(new String(message.getBody()));
        };
//        取消消息时的回调
        CancelCallback cancelCallback=consumerTag -> {
            System.out.println("消息消费被中断了");
        };
//        消费消息
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
    }
}
