package com.github.joo0003.tools.cardfactories;

import com.amazon.ask.model.ui.SimpleCard;
import com.github.joo0003.tools.utils.SimpleCardUtils;

public abstract class AbstractCardFactory implements CardFactory {

  protected SimpleCardUtils simpleCardUtils;

  protected AbstractCardFactory(SimpleCardUtils simpleCardUtils) {
    this.simpleCardUtils = simpleCardUtils;
  }

  protected SimpleCard build(String title, String text) {
    return simpleCardUtils.build(title, text);
  }
}
