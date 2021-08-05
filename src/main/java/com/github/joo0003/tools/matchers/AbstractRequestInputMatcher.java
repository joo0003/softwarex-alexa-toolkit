package com.github.joo0003.tools.matchers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.github.joo0003.tools.utils.PredicatesUtils;
import java.util.function.Predicate;

public abstract class AbstractRequestInputMatcher implements RequestInputMatcher {

  protected PredicatesUtils predicatesUtils;

  protected AbstractRequestInputMatcher(PredicatesUtils predicatesUtils) {
    this.predicatesUtils = predicatesUtils;
  }

  protected boolean match(HandlerInput input, Predicate<HandlerInput> predicate) {
    return input.matches(predicate);
  }
}
