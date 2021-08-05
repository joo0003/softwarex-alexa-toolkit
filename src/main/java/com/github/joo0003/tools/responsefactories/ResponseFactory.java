package com.github.joo0003.tools.responsefactories;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import java.util.Optional;

public interface ResponseFactory {

  Optional<Response> build(HandlerInput input);
}
