package com.github.joo0003.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.github.joo0003.helpers.CustomSkill;
import com.github.joo0003.helpers.CustomSkillBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  public CustomSkill customSkill(CustomSkillBuilder customSkillBuilder) {
    return customSkillBuilder
        .withSkillId(ApplicationConstants.SKILL_ID)
        .build();
  }

  @Bean
  public AmazonS3 amazonS3() {
    return AmazonS3ClientBuilder.defaultClient();
  }
}
