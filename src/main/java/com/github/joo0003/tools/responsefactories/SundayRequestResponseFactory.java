package com.github.joo0003.tools.responsefactories;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class SundayRequestResponseFactory extends AbstractResponseFactory {

  private final SaturdayRequestResponseFactory saturdayRequestResponseFactory;

  public SundayRequestResponseFactory(
      SaturdayRequestResponseFactory saturdayRequestResponseFactory
  ) {
    this.saturdayRequestResponseFactory = saturdayRequestResponseFactory;
  }

  @Override
  public Optional<Response> build(HandlerInput input) {
    return saturdayRequestResponseFactory.build(input);
  }
}
