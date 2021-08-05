package com.github.joo0003.tools;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UuidGenerator {

  public String generate() {
    return UUID.randomUUID().toString();
  }
}
