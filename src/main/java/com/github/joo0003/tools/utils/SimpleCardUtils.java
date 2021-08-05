package com.github.joo0003.tools.utils;

import com.amazon.ask.model.ui.SimpleCard;
import org.springframework.stereotype.Component;

@Component
public class SimpleCardUtils {

  public SimpleCard build(String title, String text) {
    return SimpleCard.builder().withTitle(title).withContent(text).build();
  }
}
