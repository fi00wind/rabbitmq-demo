package cn.coolwind.rabbitmqdemo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    Logger log = LoggerFactory.getLogger(getClass());

    /**
     * -helloworld模式
     * @param msg
     */
    @RabbitListener(queues = "test")
    public void helloWorldMsg(String msg) {
        log.info("helloWorld消费者接收到的消息："+msg);
    }

    /**
     * -work模式，消费者1
     * @param msg
     */
    @RabbitListener(queues = "workQueue")
    public void workMsg1(String msg) {
        log.info("Work消费者1:"+msg);
    }

    /**
     * -work模式，消费者2
     * @param msg
     */
    @RabbitListener(queues = "workQueue")
    public void workMsg2(String msg) {
        log.info("Work消费者2:"+msg);
    }

    @RabbitListener(queues = "#{subscribe1.name}")
    public void publish1(String msg) {
        log.info("发布订阅模式-消费者1："+msg);
    }

    @RabbitListener(queues = "#{subscribe2.name}")
    public void publish2(String msg) {
        log.info("发布订阅模式-消费者2："+msg);
    }

    @RabbitListener(queues = "#{subscribe2.name}")
    public void publish3(String msg) {
        log.info("发布订阅模式-消费者3："+msg);
    }
}
