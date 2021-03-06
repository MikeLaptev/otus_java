package com.mlaptev.app.framework;

import com.mlaptev.app.framework.annotations.After;
import com.mlaptev.app.framework.annotations.Before;
import com.mlaptev.app.framework.annotations.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Framework {

  private static final Logger logger = LogManager.getLogger(Framework.class);

  public static void executeTest(Class klass) throws ClassNotFoundException, NoSuchMethodException,
      IllegalAccessException, InvocationTargetException, InstantiationException {
    logger.info("Executing tests from class [{}]", klass.getName());

    // List of all the methods
    List<Method> methods = Arrays.asList(klass.getDeclaredMethods());

    // List of before steps
    List<Method> beforeSteps = methods.stream()
        .filter(method -> method.isAnnotationPresent(Before.class))
        .sorted(Comparator.comparing(method -> method.getDeclaredAnnotation(Before.class).order()))
        .collect(Collectors.toList());

    // List of tests
    List<Method> tests = methods.stream()
        .filter(method -> method.isAnnotationPresent(Test.class))
        .collect(Collectors.toList());

    // List of after steps
    List<Method> afterSteps = methods.stream()
        .filter(method -> method.isAnnotationPresent(After.class))
        .sorted(Comparator.comparing(method -> method.getDeclaredAnnotation(After.class).order()))
        .collect(Collectors.toList());

    for (Method test : tests) {
      // Creating a new instance of the test class
      Class<?> myClass = Class.forName(klass.getName());
      Constructor<?> constructor = myClass.getConstructor();
      Object instance = constructor.newInstance();

      // Calling before method(s)
      for (Method beforeStep : beforeSteps) {
        beforeStep.invoke(instance);
      }

      // Calling the test
      try {
        test.invoke(instance);
      }
      catch (Exception e) {
        logger.error("Exception occurs during test execution.", e);
      }

      // Calling the after method(s)
      for (Method afterStep : afterSteps) {
        afterStep.invoke(instance);
      }
    }
  }
}
