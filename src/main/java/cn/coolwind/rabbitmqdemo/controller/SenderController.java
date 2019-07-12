package cn.coolwind.rabbitmqdemo.controller;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * -生产者
 */
@RestController
public class SenderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanout;

    /**
     * -helloworld模式
     * @return
     */
    @GetMapping("/hello")
    public Object hello() {
        String msg = "Hello World 消息发送！";
        rabbitTemplate.convertAndSend("test",msg);
        return msg;
    }

    /**
     * -work模式
     * @return
     */
    @GetMapping("/work")
    public Object work() {
        StringBuffer msg = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            String content = "第" + i + "条Work Queues消息发送！";
            rabbitTemplate.convertAndSend("workQueue",content);
            msg.append(content).append("</br>");
        }
        return msg;
    }

    @GetMapping("/publish")
    public Object publish() {
        StringBuffer msg = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            String content = "第" + i + "条publish消息发送！";
            rabbitTemplate.convertAndSend(fanout.getName(),"",content);
            msg.append(content).append("</br>");
        }
        return msg;
    }
}
