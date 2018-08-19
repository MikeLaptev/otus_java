package com.mlaptev.app.tests;

import com.mlaptev.app.framework.After;
import com.mlaptev.app.framework.Before;
import com.mlaptev.app.framework.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Both before and after have the same order */
public class TwoTestsTwoBeforeAndAfterSameOrder {

  private static final Logger logger = LogManager.getLogger(TwoTestsTwoBeforeAndAfterSameOrder.class);

  public TwoTestsTwoBeforeAndAfterSameOrder() {
    logger.info("constructor");
  }

  @Before
  void firstSetUp() {
    logger.info("firstSetUp");
  }

  @Before
  void secondSetUp() {
    logger.info("secondSetUp");
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
  void firstCleanUp() {
    logger.info("firstCleanUp");
  }

  @After
  void secondCleanUp() {
    logger.info("secondCleanUp");
  }
}
