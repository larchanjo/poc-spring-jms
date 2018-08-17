package com.poc.springjms.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author luram Archanjo / 20180818
 */
@Data
@Builder
@NoArgsConstructor
public class Message implements Serializable {

  private final String content = UUID.randomUUID().toString();
  private final LocalDateTime createDate = LocalDateTime.now();

}