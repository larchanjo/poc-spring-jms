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
public class ProducerComponent {

  @Resource(name = "jms-template-queue")
  private JmsTemplate jmsTemplate;

  @Value("${application.jms.queue.test}")
  private String testQueue;

  @PostConstruct
  public void postConstruct() {
    for (int counter = 1; counter <= 3; counter++) {
      Message message = Message.builder().build();

      log.info("Producing {} to {}", message, testQueue);
      jmsTemplate.convertAndSend(testQueue, message);
    }
  }

}
