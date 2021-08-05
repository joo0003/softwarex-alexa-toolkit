package com.github.joo0003.tools.s3dumpers;

import com.github.joo0003.config.ApplicationConstants;
import com.github.joo0003.tools.utils.AmazonS3Utils;

public abstract class AbstractRawRequestS3Dumper {

  private final AmazonS3Utils amazonS3Utils;

  public AbstractRawRequestS3Dumper(AmazonS3Utils amazonS3Utils) {
    this.amazonS3Utils = amazonS3Utils;
  }

  protected void dump(String key, byte[] bytes) {
    amazonS3Utils.putObject(ApplicationConstants.S3_BUCKET_NAME, key, new String(bytes));
  }
}
