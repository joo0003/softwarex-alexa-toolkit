package com.github.joo0003.tools.matchers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.LaunchRequest;
import com.github.joo0003.tools.utils.PredicatesUtils;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class LaunchRequestMatcher extends AbstractRequestInputMatcher {

  public LaunchRequestMatcher(PredicatesUtils predicatesUtils) {
    super(predicatesUtils);
  }

  public boolean match(HandlerInput input) {
    Predicate<HandlerInput> predicate = predicatesUtils.requestType(LaunchRequest.class);
    return match(input, predicate);
  }
}
