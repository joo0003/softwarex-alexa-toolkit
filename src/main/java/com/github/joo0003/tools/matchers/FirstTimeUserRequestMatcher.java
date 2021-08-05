package com.github.joo0003.tools.matchers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.github.joo0003.config.ApplicationConstants;
import com.github.joo0003.tools.utils.AmazonS3Utils;
import com.github.joo0003.tools.utils.PredicatesUtils;
import com.github.joo0003.tools.utils.RequestEnvelopeUtils;
import org.springframework.stereotype.Component;

@Component
public class FirstTimeUserRequestMatcher extends AbstractRequestInputMatcher {

  private final RequestEnvelopeUtils requestEnvelopeUtils;
  private final AmazonS3Utils amazonS3Utils;

  public FirstTimeUserRequestMatcher(
      PredicatesUtils predicatesUtils,
      RequestEnvelopeUtils requestEnvelopeUtils,
      AmazonS3Utils amazonS3Utils
  ) {
    super(predicatesUtils);
    this.requestEnvelopeUtils = requestEnvelopeUtils;
    this.amazonS3Utils = amazonS3Utils;
  }

  public boolean match(HandlerInput input) {
    String userId = requestEnvelopeUtils.extractUserId(input.getRequestEnvelope());

    String key = ApplicationConstants.S3_FIRST_TIME_FILES_FOLDER_NAME + "/" + userId;
    boolean exists = amazonS3Utils.doesObjectExist(ApplicationConstants.S3_BUCKET_NAME, key);

    if (!exists) {
      amazonS3Utils.putObject(ApplicationConstants.S3_BUCKET_NAME, key, userId);
    }

    return !exists;
  }
}
