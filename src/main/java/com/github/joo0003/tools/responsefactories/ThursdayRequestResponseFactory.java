package com.github.joo0003.tools.responsefactories;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.github.joo0003.tools.cardfactories.ThursdayCardFactory;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ThursdayRequestResponseFactory extends AbstractResponseFactory {

  private final ThursdayCardFactory thursdayCardFactory;

  public ThursdayRequestResponseFactory(ThursdayCardFactory thursdayCardFactory) {
    this.thursdayCardFactory = thursdayCardFactory;
  }

  @Override
  public Optional<Response> build(HandlerInput input) {
    String speechText = "<insert-speech-text-here>";

    return input.getResponseBuilder()
        .withSpeech(speechText)
        .withCard(thursdayCardFactory.build())
        .withShouldEndSession(false)
        .build();
  }
}
