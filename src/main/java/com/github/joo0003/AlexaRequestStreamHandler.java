package com.github.joo0003;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.github.joo0003.exceptions.ApplicationException;
import com.github.joo0003.helpers.AlexaSkillStreamHandler;
import com.github.joo0003.helpers.CustomSkill;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlexaRequestStreamHandler implements RequestStreamHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomSkill.class);

  private static final ApplicationContext applicationContext;

  static {
    try {
      applicationContext = new SpringApplicationBuilder(Application.class).run();
    } catch (Exception e) {
      // if we fail here. We re-throw the exception to force another cold start
      LOGGER.error(ExceptionUtils.getStackTrace(e));
      throw new RuntimeException("Could not initialize Spring Boot application", e);
    }
  }

  @Override
  public void handleRequest(
      InputStream input,
      OutputStream output,
      Context context
  ) throws IOException {
    try {
      AlexaSkillStreamHandler handler = applicationContext.getBean(AlexaSkillStreamHandler.class);
      handler.handleRequest(input, output, context);
    } catch (ApplicationException applicationException) {
      // DO NOTHING
    }
  }
}