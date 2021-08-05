package com.github.joo0003.tools.responsefactories;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class SessionEndedRequestResponseFactory extends AbstractResponseFactory {

  @Override
  public Optional<Response> build(HandlerInput input) {
    return input.getResponseBuilder().build();
  }
}
