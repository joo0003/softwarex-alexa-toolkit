package com.github.joo0003.tools.responsefactories;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.github.joo0003.tools.cardfactories.MondayCardFactory;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class MondayRequestResponseFactory extends AbstractResponseFactory {

  private final MondayCardFactory mondayCardFactory;

  public MondayRequestResponseFactory(
      MondayCardFactory mondayCardFactory) {
    this.mondayCardFactory = mondayCardFactory;
  }

  @Override
  public Optional<Response> build(HandlerInput input) {
    String speechText = "<insert-speech-text-here>";

    return input.getResponseBuilder()
        .withSpeech(speechText)
        .withCard(mondayCardFactory.build())
        .withShouldEndSession(false)
        .build();
  }
}
