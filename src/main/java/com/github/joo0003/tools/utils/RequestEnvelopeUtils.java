package com.github.joo0003.tools.utils;

import com.amazon.ask.model.RequestEnvelope;
import org.springframework.stereotype.Component;

@Component
public class RequestEnvelopeUtils {

  public String extractUserId(RequestEnvelope requestEnvelope) {
    return requestEnvelope.getSession().getUser().getUserId();
  }
}
