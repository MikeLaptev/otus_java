package com.mlaptev.app.tests;

import com.mlaptev.app.framework.After;
import com.mlaptev.app.framework.Before;
import com.mlaptev.app.framework.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Before and after have different orders.
 *
 * Execution pipeline is:
 * - before (0) - ex. initialising something like A
 *  - before (1) - ex. initialising something like B, that depends on A
 *   - test
 *  - after (1) - ex. cleanup something like B, that still depends on A
 * - after (0) - ex. cleanup something like A, it should be Ok now, since B already cleaned up
 */
public class TwoTestsTwoBeforeAndAfterDiffOrder {

  private static final Logger logger = LogManager.getLogger(TwoTestsTwoBeforeAndAfterDiffOrder.class);

  public TwoTestsTwoBeforeAndAfterDiffOrder() {
    logger.info("constructor");
  }

  @Before(order = 0)
  void firstSetUp() {
    logger.info("firstSetUp");
  }

  @Before(order = 1)
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

  @After(order = 1)
  void firstCleanUp() {
    logger.info("firstCleanUp");
  }

  @After(order = 0)
  void secondCleanUp() {
    logger.info("secondCleanUp");
  }
}
