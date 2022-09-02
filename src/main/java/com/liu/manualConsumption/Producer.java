package com.liu.manualConsumption;

import com.liu.utils.RabbitmqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * All rights Reserved, Designed By jiexingcloud.
 *
 * @author 刘帅彪
 * @Date2022/9/1 11:40
 * Copyright ©2022 jiexingcloud. All rights reserved.
 * 注意：本内容仅限于结行云创内部传阅，禁止外泄以及用于其他的商业用途。
 */

public class Producer {
    private static final String QUEUE_NAME="RabbitmqName";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitmqUtils.getChannel();
//        声明一个队列，并且设置一些参数
        /**
         String queue：队列名称
         boolean durable：是否把队列里面的信息持久化
         boolean exclusive：该队列里面的消息是否只供一个消费者进行消费，true：是，false：否
         boolean autoDelete：最后一个消费者断开连接后，是否自动删除消息，true：是，false：否
         Map<String, Object> arguments：其他参数
        */
//       durable=true;代表持久化
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
//        String message="hello world";
//        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
//        System.out.println("消息发送完毕");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
//            将消息放入队列
            channel.basicPublish("",QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,scanner.next().getBytes());
            System.out.println("消息发送成功");
        }
    }
}
