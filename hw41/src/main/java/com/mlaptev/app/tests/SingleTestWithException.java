package com.mlaptev.app.tests;

import com.mlaptev.app.framework.annotations.After;
import com.mlaptev.app.framework.annotations.Before;
import com.mlaptev.app.framework.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingleTestWithException {

  private static final Logger logger = LogManager.getLogger(SingleTestWithException.class);

  public SingleTestWithException() {
    logger.info("constructor");
  }

  @Before
  public void setUp() {
    logger.info("setUp");
  }

  @Test
  public void firstTest() {
    throw new NullPointerException("Example of exception.");
  }

  @After
  public void cleanUp() {
    logger.info("cleanUp");
  }
}
