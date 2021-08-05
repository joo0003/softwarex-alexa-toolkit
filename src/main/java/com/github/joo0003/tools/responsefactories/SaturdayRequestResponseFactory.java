package com.github.joo0003.tools.responsefactories;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class SaturdayRequestResponseFactory extends AbstractResponseFactory {

  @Override
  public Optional<Response> build(HandlerInput input) {
    String speechText = "<insert-speech-text-here>";

    return input.getResponseBuilder()
        .withSpeech(speechText)
        .withShouldEndSession(false)
        .build();
  }
}
