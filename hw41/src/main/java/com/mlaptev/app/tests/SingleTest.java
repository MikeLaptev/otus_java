package com.mlaptev.app.tests;

import com.mlaptev.app.framework.annotations.After;
import com.mlaptev.app.framework.annotations.Before;
import com.mlaptev.app.framework.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingleTest {

  private static final Logger logger = LogManager.getLogger(SingleTest.class);

  public SingleTest() {
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

  @After
  public void cleanUp() {
    logger.info("cleanUp");
  }
}
