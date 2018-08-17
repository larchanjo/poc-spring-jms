package com.poc.springjms;

import javax.jms.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author luram Archanjo / 20180818
 */
@SpringBootApplication
@EnableJms
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean("jms-template-queue")
  public JmsTemplate createJmsTemplateQueue(ConnectionFactory connectionFactory) {
    JmsTemplate jmsTemplate = new JmsTemplate();
    jmsTemplate.setConnectionFactory(connectionFactory);
    jmsTemplate.setPubSubDomain(Boolean.FALSE);

    return jmsTemplate;
  }

  @Bean("jms-template-topic")
  public JmsTemplate createJmsTemplateTopic(ConnectionFactory connectionFactory) {
    JmsTemplate jmsTemplate = new JmsTemplate();
    jmsTemplate.setConnectionFactory(connectionFactory);
    jmsTemplate.setPubSubDomain(Boolean.TRUE);

    return jmsTemplate;
  }

}
