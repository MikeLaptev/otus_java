package com.mlaptev.app;

import com.mlaptev.app.framework.Framework;
import com.mlaptev.app.tests.SingleTest;
import com.mlaptev.app.tests.TwoTests;
import com.mlaptev.app.tests.TwoTestsTwoBeforeAndAfterDiffOrder;
import com.mlaptev.app.tests.TwoTestsTwoBeforeAndAfterSameOrder;

public class App {

  public static void main(String[] args) {
    Framework.executeTest(SingleTest.class);
    Framework.executeTest(TwoTests.class);
    Framework.executeTest(TwoTestsTwoBeforeAndAfterSameOrder.class);
    Framework.executeTest(TwoTestsTwoBeforeAndAfterDiffOrder.class);
  }
}
