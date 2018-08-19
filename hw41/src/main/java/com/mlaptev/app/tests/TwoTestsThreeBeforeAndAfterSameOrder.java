package com.mlaptev.app.tests;

import com.mlaptev.app.framework.annotations.After;
import com.mlaptev.app.framework.annotations.Before;
import com.mlaptev.app.framework.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Both before and after have the same order
 */
public class TwoTestsThreeBeforeAndAfterSameOrder {

  private static final Logger logger = LogManager
      .getLogger(TwoTestsThreeBeforeAndAfterSameOrder.class);

  public TwoTestsThreeBeforeAndAfterSameOrder() {
    logger.info("constructor");
  }

  @Before
  public void firstSetUp() {
    logger.info("firstSetUp");
  }

  @Before
  public void secondSetUp() {
    logger.info("secondSetUp");
  }

  @Before
  public void thirdSetUp() {
    logger.info("thirdSetUp");
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
  public void thirdCleanUp() {
    logger.info("thirdCleanUp");
  }

  @After
  public void secondCleanUp() {
    logger.info("secondCleanUp");
  }

  @After
  public void firstCleanUp() {
    logger.info("firstCleanUp");
  }
}
