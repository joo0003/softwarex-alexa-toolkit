package com.github.joo0003.tools.responsefactories;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.github.joo0003.tools.cardfactories.FridayCardFactory;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class FridayRequestResponseFactory extends AbstractResponseFactory {

  private final FridayCardFactory fridayCardFactory;

  public FridayRequestResponseFactory(FridayCardFactory fridayCardFactory) {
    this.fridayCardFactory = fridayCardFactory;
  }

  @Override
  public Optional<Response> build(HandlerInput input) {
    String speechText = "<insert-speech-text-here>";

    return input.getResponseBuilder()
        .withSpeech(speechText)
        .withCard(fridayCardFactory.build())
        .withShouldEndSession(false)
        .build();
  }
}
