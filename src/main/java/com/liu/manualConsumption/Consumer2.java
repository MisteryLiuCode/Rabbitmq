package com.liu.manualConsumption;

import com.liu.utils.RabbitmqUtils;
import com.liu.utils.ThreadSleep;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

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

public class Consumer2 {

    private static final String QUEUE_NAME="RabbitmqName";

    public static void main(String[] args) throws IOException, TimeoutException {

        Channel channel = RabbitmqUtils.getChannel();

//        接收消息的回调
        DeliverCallback deliverCallback=(consumerTag,message)->{
//            接收到之后进行沉睡1s，模拟消息处理
            ThreadSleep.sleep(30);
//            输出消息
            System.out.println(new String(message.getBody()));
//            消息应答
//            message.getEnvelope().getDeliveryTag()指定应答的消息id
            channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
        };
//        取消消息时的回调
        CancelCallback cancelCallback=consumerTag -> {
            System.out.println("消息消费被中断了");
        };
//        消费消息(手动应答)
        System.out.println("此消费者消费消息较慢");
        channel.basicQos(1);
        channel.basicConsume(QUEUE_NAME,false,deliverCallback,cancelCallback);
    }
}
