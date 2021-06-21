package com.polozov.spring2.lesson06;

import com.polozov.spring2.lesson06.domain.Product;
import com.polozov.spring2.lesson06.integration.ChannelGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Arrays;

@SpringBootApplication
@IntegrationComponentScan
public class SpringIntegrationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringIntegrationApplication.class, args);

        DirectChannel invokeCallGetProducts = context.getBean("invokeCallGetProducts", DirectChannel.class);
        invokeCallGetProducts.send(MessageBuilder.withPayload("").build()); // empty message for initialization

        PollableChannel productsChannel = context.getBean("get_products_channel", PollableChannel.class);
        Message<?> receive = productsChannel.receive();
        System.out.println(receive);
        System.out.println(receive.getPayload());
    }

}
