package com.github.joo0003.tools.utils;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.stereotype.Component;

@Component
public class AmazonS3Utils {

  private final AmazonS3 amazonS3;

  public AmazonS3Utils(AmazonS3 amazonS3) {
    this.amazonS3 = amazonS3;
  }

  public void putObject(String bucketName, String key, String content) {
    amazonS3.putObject(bucketName, key, content);
  }

  public boolean doesObjectExist(String bucketName, String key) {
    return amazonS3.doesObjectExist(bucketName, key);
  }
}
