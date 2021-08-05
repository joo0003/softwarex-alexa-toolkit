package com.github.joo0003.tools.cardfactories;

import com.amazon.ask.model.ui.SimpleCard;
import com.github.joo0003.tools.utils.SimpleCardUtils;
import org.springframework.stereotype.Component;

@Component
public class TuesdayCardFactory extends AbstractCardFactory {

  public TuesdayCardFactory(SimpleCardUtils simpleCardUtils) {
    super(simpleCardUtils);
  }

  @Override
  public SimpleCard build() {
    String cardTitle = "<insert-card-title-here>";

    String cardText = "<insert-card-text-here>";

    return build(cardTitle, cardText);
  }
}
