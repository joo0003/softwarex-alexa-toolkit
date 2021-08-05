package com.github.joo0003.tools.matchers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.github.joo0003.config.ApplicationConstants;
import com.github.joo0003.tools.utils.PredicatesUtils;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class SaturdayRequestMatcher extends AbstractRequestInputMatcher {

  public SaturdayRequestMatcher(
      PredicatesUtils predicatesUtils
  ) {
    super(predicatesUtils);
  }

  public boolean match(HandlerInput input) {
    Predicate<HandlerInput> predicate = predicatesUtils.intentName(
        ApplicationConstants.SATURDAY_INTENT_NAME
    );
    return match(input, predicate);
  }
}
