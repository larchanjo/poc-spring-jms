package com.poc.springjms.domain;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author luram Archanjo / 20180818
 */
@Component
@Slf4j
public class PublisherComponent {

  @Resource(name = "jms-template-topic")
  private JmsTemplate jmsTemplate;

  @Value("${application.jms.topic.test}")
  private String testTopic;

  @PostConstruct
  public void postConstruct() {
    for (int counter = 1; counter <= 3; counter++) {
      Message message = Message.builder().build();

      log.info("Publishing {} to {}", message, testTopic);
      jmsTemplate.convertAndSend(testTopic, message);
    }
  }

}
