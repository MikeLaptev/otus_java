package com.mlaptev.app.tests;

import com.mlaptev.app.framework.After;
import com.mlaptev.app.framework.Before;
import com.mlaptev.app.framework.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TwoTests {

  private static final Logger logger = LogManager.getLogger(TwoTests.class);

  public TwoTests() {
    logger.info("constructor");
  }

  @Before
  void setUp() {
    logger.info("setUp");
  }

  @Test
  void firstTest() {
    logger.info("firstTest");
  }

  @Test
  void secondTest() {
    logger.info("secondTest");
  }

  @After
  void cleanUp() {
    logger.info("cleanUp");
  }
}
