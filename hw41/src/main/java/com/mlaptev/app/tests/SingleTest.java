package com.mlaptev.app.tests;

import com.mlaptev.app.framework.After;
import com.mlaptev.app.framework.Before;
import com.mlaptev.app.framework.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingleTest {

  private static final Logger logger = LogManager.getLogger(SingleTest.class);

  public SingleTest() {
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

  @After
  void cleanUp() {
    logger.info("cleanUp");
  }
}
