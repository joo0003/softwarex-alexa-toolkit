package com.github.joo0003.tools.responsefactories;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class NavigateHomeRequestResponseFactory extends AbstractResponseFactory {

  private final SessionEndedRequestResponseFactory sessionEndedRequestResponseFactory;

  public NavigateHomeRequestResponseFactory(
      SessionEndedRequestResponseFactory sessionEndedRequestResponseFactory
  ) {
    this.sessionEndedRequestResponseFactory = sessionEndedRequestResponseFactory;
  }

  @Override
  public Optional<Response> build(HandlerInput input) {
    return sessionEndedRequestResponseFactory.build(input);
  }
}
