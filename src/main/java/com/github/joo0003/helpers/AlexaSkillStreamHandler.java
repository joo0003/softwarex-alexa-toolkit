package com.github.joo0003.helpers;

import com.amazon.ask.SkillStreamHandler;
import org.springframework.stereotype.Component;

@Component
public class AlexaSkillStreamHandler extends SkillStreamHandler {

  public AlexaSkillStreamHandler(CustomSkill customSkill) {
    super(customSkill);
  }
}
