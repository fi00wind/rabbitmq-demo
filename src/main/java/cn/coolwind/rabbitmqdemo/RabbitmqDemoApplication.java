package cn.coolwind.rabbitmqdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqDemoApplication {
    static Logger log = LoggerFactory.getLogger(RabbitmqDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqDemoApplication.class, args);
        log.info("#############################系统启动成功！");
    }

    /**
     *  helloworld模式队列
     * @return
     */
    @Bean
    public Queue testQueue() {
        return new Queue("test");
    }

    /**
     * work 模式队列
     * @return
     */
    @Bean
    public Queue workQueue() {
        return new Queue("workQueue");
    }

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("publish");
    }

    @Bean
    public Queue subscribe1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue subscribe2() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding1(FanoutExchange fanout, Queue subscribe1) {
        return BindingBuilder.bind(subscribe1).to(fanout);
    }

    @Bean
    public Binding binding2(FanoutExchange fanout, Queue subscribe2) {
        return BindingBuilder.bind(subscribe2).to(fanout);
    }











}
