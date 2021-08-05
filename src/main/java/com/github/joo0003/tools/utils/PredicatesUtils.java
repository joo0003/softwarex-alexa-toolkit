package com.github.joo0003.tools.utils;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Request;
import com.amazon.ask.request.Predicates;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class PredicatesUtils {

  public Predicate<HandlerInput> requestType(Class<? extends Request> clazz) {
    return Predicates.requestType(clazz);
  }

  public Predicate<HandlerInput> intentName(String intentName) {
    return Predicates.intentName(intentName);
  }
}
