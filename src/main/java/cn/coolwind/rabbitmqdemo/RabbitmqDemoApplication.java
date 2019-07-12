package cn.coolwind.rabbitmqdemo;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqDemoApplication.class, args);
        System.out.println("#############################系统启动成功！");
    }

    @Bean
    public Queue myQueue() {
        return new Queue("test");
    }

}
