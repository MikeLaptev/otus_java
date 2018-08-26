package com.mlaptev.app;

import com.mlaptev.app.framework.Framework;
import com.mlaptev.app.tests.SingleTest;
import com.mlaptev.app.tests.SingleTestWithException;
import com.mlaptev.app.tests.TwoTests;
import com.mlaptev.app.tests.TwoTestsThreeBeforeAndAfterDiffOrder;
import com.mlaptev.app.tests.TwoTestsThreeBeforeAndAfterSameOrder;
import java.lang.reflect.InvocationTargetException;

public class App {

  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
      InvocationTargetException, InstantiationException, IllegalAccessException {
    Framework.executeTest(SingleTest.class);
    Framework.executeTest(TwoTests.class);
    Framework.executeTest(TwoTestsThreeBeforeAndAfterSameOrder.class);
    Framework.executeTest(TwoTestsThreeBeforeAndAfterDiffOrder.class);
    Framework.executeTest(SingleTestWithException.class);
  }
}
