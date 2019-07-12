package cn.coolwind.rabbitmqdemo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = "test")
    public void helloWorldMsg(String msg) {
        System.out.println("helloWorld消费者接收到的消息："+msg);
    }

    @RabbitListener(queues = "workQueue")
    public void workMsg1(String msg) {
        System.out.println("Work消费者1:"+msg);
    }

    @RabbitListener(queues = "workQueue")
    public void workMsg2(String msg) {
        System.out.println("Work消费者2:"+msg);
    }
}
