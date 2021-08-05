package com.github.joo0003.tools.responsefactories;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.github.joo0003.tools.cardfactories.WednesdayCardFactory;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class WednesdayRequestResponseFactory extends AbstractResponseFactory {

  private final WednesdayCardFactory wednesdayCardFactory;

  public WednesdayRequestResponseFactory(WednesdayCardFactory wednesdayCardFactory) {
    this.wednesdayCardFactory = wednesdayCardFactory;
  }

  @Override
  public Optional<Response> build(HandlerInput input) {
    String speechText = "<insert-speech-text-here>";

    return input.getResponseBuilder()
        .withSpeech(speechText)
        .withCard(wednesdayCardFactory.build())
        .withShouldEndSession(false)
        .build();
  }
}
