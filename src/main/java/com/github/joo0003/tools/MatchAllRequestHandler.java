package com.github.joo0003.tools;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.github.joo0003.tools.responsefactories.ResponseFactory;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class MatchAllRequestHandler implements RequestHandler {

  private final ResponseFactorySelector responseFactorySelector;

  public MatchAllRequestHandler(
      ResponseFactorySelector responseFactorySelector
  ) {
    this.responseFactorySelector = responseFactorySelector;
  }

  @Override
  public boolean canHandle(HandlerInput input) {
    return true;
  }

  @Override
  public Optional<Response> handle(HandlerInput input) {
    ResponseFactory responseFactory = responseFactorySelector.select(input);
    return responseFactory.build(input);
  }

}