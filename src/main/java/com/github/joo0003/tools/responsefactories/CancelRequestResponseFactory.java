package com.github.joo0003.tools.responsefactories;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class CancelRequestResponseFactory extends AbstractResponseFactory {

  private final StopRequestResponseFactory stopRequestResponseFactory;

  public CancelRequestResponseFactory(
      StopRequestResponseFactory stopRequestResponseFactory
  ) {
    this.stopRequestResponseFactory = stopRequestResponseFactory;
  }

  @Override
  public Optional<Response> build(HandlerInput input) {
    return stopRequestResponseFactory.build(input);
  }
}
