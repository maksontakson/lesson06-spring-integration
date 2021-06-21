package com.polozov.spring2.lesson06.integration;

import com.polozov.spring2.lesson06.domain.Product;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Target for product-message
 */
@MessagingGateway
public interface ChannelGateway {
    @Gateway(requestChannel = "channel")
    void process(Product product);
}