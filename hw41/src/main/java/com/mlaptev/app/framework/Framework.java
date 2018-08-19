package com.mlaptev.app.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Framework {

  private static final Logger logger = LogManager.getLogger(Framework.class);

  public static void executeTest(Class klass) {
    logger.info("Executing tests from class [{}]", klass.getName());
  }
}
