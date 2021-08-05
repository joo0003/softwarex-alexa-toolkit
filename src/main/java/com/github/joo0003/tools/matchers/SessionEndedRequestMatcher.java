package com.github.joo0003.tools.matchers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.SessionEndedRequest;
import com.github.joo0003.tools.utils.PredicatesUtils;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class SessionEndedRequestMatcher extends AbstractRequestInputMatcher {

  public SessionEndedRequestMatcher(PredicatesUtils predicatesUtils) {
    super(predicatesUtils);
  }

  public boolean match(HandlerInput input) {
    Predicate<HandlerInput> predicate = predicatesUtils.requestType(SessionEndedRequest.class);
    return match(input, predicate);
  }
}
