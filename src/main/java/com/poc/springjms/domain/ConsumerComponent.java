package com.poc.springjms.domain;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author luram Archanjo / 20180818
 */
@Component
@Slf4j
public class ConsumerComponent {

  @JmsListener(destination = "${application.jms.queue.test}")
  public void consumer(@NonNull Message message) {
    log.info("Consuming {}", message);
  }

}
