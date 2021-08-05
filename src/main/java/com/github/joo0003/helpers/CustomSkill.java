package com.github.joo0003.helpers;

import com.amazon.ask.Skill;
import com.amazon.ask.builder.SkillConfiguration;
import com.amazon.ask.model.ResponseEnvelope;
import com.amazon.ask.request.SkillRequest;
import com.amazon.ask.response.SkillResponse;
import com.github.joo0003.tools.UuidGenerator;
import com.github.joo0003.tools.s3dumpers.InputRawRequestS3Dumper;
import com.github.joo0003.tools.s3dumpers.OutputRawRequestS3Dumper;

public class CustomSkill extends Skill {

  private final UuidGenerator uuidGenerator;
  private final InputRawRequestS3Dumper inputRawRequestS3Dumper;
  private final OutputRawRequestS3Dumper outputRawRequestS3Dumper;

  public CustomSkill(
      SkillConfiguration config,
      UuidGenerator uuidGenerator,
      InputRawRequestS3Dumper inputRawRequestS3Dumper,
      OutputRawRequestS3Dumper outputRawRequestS3Dumper
  ) {
    super(config);
    this.uuidGenerator = uuidGenerator;
    this.inputRawRequestS3Dumper = inputRawRequestS3Dumper;
    this.outputRawRequestS3Dumper = outputRawRequestS3Dumper;
  }

  @Override
  public SkillResponse<ResponseEnvelope> execute(SkillRequest request, Object context) {
    return doExecute(request, context);
  }

  private SkillResponse<ResponseEnvelope> doExecute(SkillRequest request, Object context) {
    String executionId = uuidGenerator.generate();

    inputRawRequestS3Dumper.dump(executionId, request.getRawRequest());

    SkillResponse<ResponseEnvelope> response = super.execute(request, context);

    if (response.isPresent()) {
      outputRawRequestS3Dumper.dump(executionId, response.getRawResponse());
    }

    return response;
  }
}
