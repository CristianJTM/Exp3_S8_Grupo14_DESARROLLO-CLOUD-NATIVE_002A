package com.duoc.transportmanagement.config;

import com.duoc.transportmanagement.util.RabbitConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // GUIAS

    @Bean
    public Queue guiaQueue() {
        return new Queue(RabbitConstants.GUIA_QUEUE, true);
    }

    @Bean
    public Queue guiaDlq() {
        return new Queue(RabbitConstants.GUIA_DLQ, true);
    }

    // TRANSPORTISTAS

    @Bean
    public Queue transportistaQueue() {
        return new Queue(RabbitConstants.TRANSPORTISTA_QUEUE, true);
    }

    @Bean
    public Queue transportistaDlq() {
        return new Queue(RabbitConstants.TRANSPORTISTA_DLQ, true);
    }

    // JSON

    @Bean
    public MessageConverter jsonMessageConverter() {

        Jackson2JsonMessageConverter converter =
                new Jackson2JsonMessageConverter();

        DefaultJackson2JavaTypeMapper typeMapper =
                new DefaultJackson2JavaTypeMapper();

        typeMapper.setTrustedPackages("*");
        typeMapper.setTypePrecedence(
                Jackson2JavaTypeMapper.TypePrecedence.INFERRED);

        converter.setJavaTypeMapper(typeMapper);

        return converter;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(
            ConnectionFactory connectionFactory,
            MessageConverter messageConverter) {

        RabbitTemplate template =
                new RabbitTemplate(connectionFactory);

        template.setMessageConverter(messageConverter);

        return template;
    }

}