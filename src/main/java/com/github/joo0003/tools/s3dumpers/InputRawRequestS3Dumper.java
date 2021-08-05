package com.github.joo0003.tools.s3dumpers;

import com.github.joo0003.config.ApplicationConstants;
import com.github.joo0003.tools.utils.AmazonS3Utils;
import org.springframework.stereotype.Component;

@Component
public class InputRawRequestS3Dumper extends AbstractRawRequestS3Dumper {

  public InputRawRequestS3Dumper(AmazonS3Utils amazonS3Utils) {
    super(amazonS3Utils);
  }

  public void dump(String executionId, byte[] bytes) {
    String fileName = executionId + ":::" + "raw-input";
    String key = ApplicationConstants.S3_RAW_FILES_FOLDER_NAME + "/" + fileName;
    super.dump(key, bytes);
  }
}
