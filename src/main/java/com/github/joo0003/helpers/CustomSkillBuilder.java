package com.github.joo0003.helpers;

import com.amazon.ask.builder.SkillConfiguration;
import com.amazon.ask.builder.StandardSkillBuilder;
import com.github.joo0003.tools.MatchAllRequestHandler;
import com.github.joo0003.tools.UuidGenerator;
import com.github.joo0003.tools.s3dumpers.InputRawRequestS3Dumper;
import com.github.joo0003.tools.s3dumpers.OutputRawRequestS3Dumper;
import org.springframework.stereotype.Component;

@Component
public class CustomSkillBuilder extends StandardSkillBuilder {

  private final UuidGenerator uuidGenerator;
  private final InputRawRequestS3Dumper inputRawRequestS3Dumper;
  private final OutputRawRequestS3Dumper outputRawRequestS3Dumper;
  private final MatchAllRequestHandler matchAllRequestHandler;

  public CustomSkillBuilder(
      UuidGenerator uuidGenerator,
      InputRawRequestS3Dumper inputRawRequestS3Dumper,
      OutputRawRequestS3Dumper outputRawRequestS3Dumper,
      MatchAllRequestHandler matchAllRequestHandler
  ) {
    this.uuidGenerator = uuidGenerator;
    this.inputRawRequestS3Dumper = inputRawRequestS3Dumper;
    this.outputRawRequestS3Dumper = outputRawRequestS3Dumper;
    this.matchAllRequestHandler = matchAllRequestHandler;
  }

  @Override
  public CustomSkill build() {
    addRequestHandlers(matchAllRequestHandler);

    SkillConfiguration skillConfiguration = getConfigBuilder().build();

    return new CustomSkill(
        skillConfiguration,
        uuidGenerator,
        inputRawRequestS3Dumper,
        outputRawRequestS3Dumper
    );
  }

  @Override
  public CustomSkillBuilder withSkillId(String skillId) {
    return (CustomSkillBuilder) super.withSkillId(skillId);
  }
}
