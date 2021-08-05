package com.github.joo0003.tools.matchers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;

public interface RequestInputMatcher {

  boolean match(HandlerInput input);
}
