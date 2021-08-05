package com.github.joo0003.tools.responsefactories;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.github.joo0003.tools.cardfactories.TuesdayCardFactory;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TuesdayRequestResponseFactory extends AbstractResponseFactory {

  private final TuesdayCardFactory tuesdayCardFactory;

  public TuesdayRequestResponseFactory(TuesdayCardFactory tuesdayCardFactory) {
    this.tuesdayCardFactory = tuesdayCardFactory;
  }

  @Override
  public Optional<Response> build(HandlerInput input) {
    String speechText = "<insert-speech-text-here>";

    return input.getResponseBuilder()
        .withSpeech(speechText)
        .withCard(tuesdayCardFactory.build())
        .withShouldEndSession(false)
        .build();
  }
}
