package com.mlaptev.app.tests;

import com.mlaptev.app.framework.annotations.After;
import com.mlaptev.app.framework.annotations.Before;
import com.mlaptev.app.framework.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TwoTests {

  private static final Logger logger = LogManager.getLogger(TwoTests.class);

  public TwoTests() {
    logger.info("constructor");
  }

  @Before
  public void setUp() {
    logger.info("setUp");
  }

  @Test
  public void firstTest() {
    logger.info("firstTest");
  }

  @Test
  public void secondTest() {
    logger.info("secondTest");
  }

  @After
  public void cleanUp() {
    logger.info("cleanUp");
  }
}
