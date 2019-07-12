package cn.coolwind.rabbitmqdemo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/hello")
    public Object hello() {
        String msg = "Hello World 消息发送！";
        rabbitTemplate.convertAndSend("test",msg);
        return msg;
    }

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
}
