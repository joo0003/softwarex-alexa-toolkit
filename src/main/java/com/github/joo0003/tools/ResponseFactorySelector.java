package com.github.joo0003.tools;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.github.joo0003.exceptions.ApplicationException;
import com.github.joo0003.tools.matchers.CancelRequestMatcher;
import com.github.joo0003.tools.matchers.FallbackRequestMatcher;
import com.github.joo0003.tools.matchers.FirstTimeUserRequestMatcher;
import com.github.joo0003.tools.matchers.FridayRequestMatcher;
import com.github.joo0003.tools.matchers.HelpRequestMatcher;
import com.github.joo0003.tools.matchers.LaunchRequestMatcher;
import com.github.joo0003.tools.matchers.MondayRequestMatcher;
import com.github.joo0003.tools.matchers.NavigateHomeRequestMatcher;
import com.github.joo0003.tools.matchers.RequestInputMatcher;
import com.github.joo0003.tools.matchers.SaturdayRequestMatcher;
import com.github.joo0003.tools.matchers.SessionEndedRequestMatcher;
import com.github.joo0003.tools.matchers.StopRequestMatcher;
import com.github.joo0003.tools.matchers.SundayRequestMatcher;
import com.github.joo0003.tools.matchers.ThursdayRequestMatcher;
import com.github.joo0003.tools.matchers.TuesdayRequestMatcher;
import com.github.joo0003.tools.matchers.WednesdayRequestMatcher;
import com.github.joo0003.tools.responsefactories.CancelRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.FallbackRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.FirstTimeUserRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.FridayRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.HelpRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.LaunchRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.MondayRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.NavigateHomeRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.ResponseFactory;
import com.github.joo0003.tools.responsefactories.SaturdayRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.SessionEndedRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.StopRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.SundayRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.ThursdayRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.TuesdayRequestResponseFactory;
import com.github.joo0003.tools.responsefactories.WednesdayRequestResponseFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ResponseFactorySelector {

  private final ApplicationContext applicationContext;

  public ResponseFactorySelector(
      ApplicationContext applicationContext
  ) {
    this.applicationContext = applicationContext;
  }

  public ResponseFactory select(HandlerInput input) {
    if (isFirstTimeForUser(input)) {
      return responseFactory(FirstTimeUserRequestResponseFactory.class);
    }

    if (isLaunchRequest(input)) {
      return responseFactory(LaunchRequestResponseFactory.class);
    }

    if (isSessionEndedRequest(input)) {
      return responseFactory(SessionEndedRequestResponseFactory.class);
    }

    if (isCancelRequest(input)) {
      return responseFactory(CancelRequestResponseFactory.class);
    }

    if (isStopRequest(input)) {
      return responseFactory(StopRequestResponseFactory.class);
    }

    if (isHelpRequest(input)) {
      return responseFactory(HelpRequestResponseFactory.class);
    }

    if (isNavigateHomeRequest(input)) {
      return responseFactory(NavigateHomeRequestResponseFactory.class);
    }

    if (isFallbackRequest(input)) {
      return responseFactory(FallbackRequestResponseFactory.class);
    }

    if (isMondayRequest(input)) {
      return responseFactory(MondayRequestResponseFactory.class);
    }

    if (isTuesdayRequest(input)) {
      return responseFactory(TuesdayRequestResponseFactory.class);
    }

    if (isWednesdayRequest(input)) {
      return responseFactory(WednesdayRequestResponseFactory.class);
    }

    if (isThursdayRequest(input)) {
      return responseFactory(ThursdayRequestResponseFactory.class);
    }

    if (isFridayRequest(input)) {
      return responseFactory(FridayRequestResponseFactory.class);
    }

    if (isSaturdayRequest(input)) {
      return responseFactory(SaturdayRequestResponseFactory.class);
    }

    if (isSundayRequest(input)) {
      return responseFactory(SundayRequestResponseFactory.class);
    }

    throw new ApplicationException("Could not match input!");
  }

  private boolean isFallbackRequest(HandlerInput input) {
    return matcher(FallbackRequestMatcher.class).match(input);
  }

  private boolean isSessionEndedRequest(HandlerInput input) {
    return matcher(SessionEndedRequestMatcher.class).match(input);
  }

  private boolean isNavigateHomeRequest(HandlerInput input) {
    return matcher(NavigateHomeRequestMatcher.class).match(input);
  }

  private boolean isHelpRequest(HandlerInput input) {
    return matcher(HelpRequestMatcher.class).match(input);
  }

  private boolean isStopRequest(HandlerInput input) {
    return matcher(StopRequestMatcher.class).match(input);
  }

  private boolean isCancelRequest(HandlerInput input) {
    return matcher(CancelRequestMatcher.class).match(input);
  }

  private boolean isSundayRequest(HandlerInput input) {
    return matcher(SundayRequestMatcher.class).match(input);
  }

  private boolean isSaturdayRequest(HandlerInput input) {
    return matcher(SaturdayRequestMatcher.class).match(input);
  }

  private boolean isFridayRequest(HandlerInput input) {
    return matcher(FridayRequestMatcher.class).match(input);
  }

  private boolean isThursdayRequest(HandlerInput input) {
    return matcher(ThursdayRequestMatcher.class).match(input);
  }

  private boolean isWednesdayRequest(HandlerInput input) {
    return matcher(WednesdayRequestMatcher.class).match(input);
  }

  private boolean isTuesdayRequest(HandlerInput input) {
    return matcher(TuesdayRequestMatcher.class).match(input);
  }

  private boolean isMondayRequest(HandlerInput input) {
    return matcher(MondayRequestMatcher.class).match(input);
  }

  private boolean isLaunchRequest(HandlerInput input) {
    return matcher(LaunchRequestMatcher.class).match(input);
  }

  private boolean isFirstTimeForUser(HandlerInput input) {
    return matcher(FirstTimeUserRequestMatcher.class).match(input);
  }

  private ResponseFactory responseFactory(Class<? extends ResponseFactory> clazz) {
    return applicationContext.getBean(clazz);
  }

  private RequestInputMatcher matcher(Class<? extends RequestInputMatcher> clazz) {
    return applicationContext.getBean(clazz);
  }
}
