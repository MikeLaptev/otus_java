### Results

#### Before applying ordering

```bash
"C:\Program Files\Java\jdk-10.0.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2018.1.5\lib\idea_rt.jar=61892:C:\Program Files\JetBrains\IntelliJ IDEA 2018.1.5\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Mikhail\Documents\Development\otus_java\hw41\target\classes;C:\Users\Mikhail\.m2\repository\org\apache\logging\log4j\log4j-api\2.11.0\log4j-api-2.11.0.jar;C:\Users\Mikhail\.m2\repository\org\apache\logging\log4j\log4j-core\2.11.0\log4j-core-2.11.0.jar com.mlaptev.app.App
[INFO ] 2018-08-19 22:58:28.841 [main] Framework - Executing tests from class [com.mlaptev.app.tests.SingleTest]
[INFO ] 2018-08-19 22:58:28.881 [main] SingleTest - constructor
[INFO ] 2018-08-19 22:58:28.881 [main] SingleTest - setUp
[INFO ] 2018-08-19 22:58:28.882 [main] SingleTest - firstTest
[INFO ] 2018-08-19 22:58:28.882 [main] SingleTest - cleanUp
[INFO ] 2018-08-19 22:58:28.883 [main] Framework - Executing tests from class [com.mlaptev.app.tests.TwoTests]
[INFO ] 2018-08-19 22:58:28.887 [main] TwoTests - constructor
[INFO ] 2018-08-19 22:58:28.887 [main] TwoTests - setUp
[INFO ] 2018-08-19 22:58:28.887 [main] TwoTests - firstTest
[INFO ] 2018-08-19 22:58:28.888 [main] TwoTests - cleanUp
[INFO ] 2018-08-19 22:58:28.888 [main] TwoTests - constructor
[INFO ] 2018-08-19 22:58:28.888 [main] TwoTests - setUp
[INFO ] 2018-08-19 22:58:28.888 [main] TwoTests - secondTest
[INFO ] 2018-08-19 22:58:28.888 [main] TwoTests - cleanUp
[INFO ] 2018-08-19 22:58:28.894 [main] Framework - Executing tests from class [com.mlaptev.app.tests.TwoTestsThreeBeforeAndAfterSameOrder]
[INFO ] 2018-08-19 22:58:28.896 [main] TwoTestsThreeBeforeAndAfterSameOrder - constructor
[INFO ] 2018-08-19 22:58:28.896 [main] TwoTestsThreeBeforeAndAfterSameOrder - secondSetUp
[INFO ] 2018-08-19 22:58:28.896 [main] TwoTestsThreeBeforeAndAfterSameOrder - thirdSetUp
[INFO ] 2018-08-19 22:58:28.896 [main] TwoTestsThreeBeforeAndAfterSameOrder - firstSetUp
[INFO ] 2018-08-19 22:58:28.896 [main] TwoTestsThreeBeforeAndAfterSameOrder - firstTest
[INFO ] 2018-08-19 22:58:28.896 [main] TwoTestsThreeBeforeAndAfterSameOrder - secondCleanUp
[INFO ] 2018-08-19 22:58:28.896 [main] TwoTestsThreeBeforeAndAfterSameOrder - firstCleanUp
[INFO ] 2018-08-19 22:58:28.897 [main] TwoTestsThreeBeforeAndAfterSameOrder - thirdCleanUp
[INFO ] 2018-08-19 22:58:28.897 [main] TwoTestsThreeBeforeAndAfterSameOrder - constructor
[INFO ] 2018-08-19 22:58:28.897 [main] TwoTestsThreeBeforeAndAfterSameOrder - secondSetUp
[INFO ] 2018-08-19 22:58:28.897 [main] TwoTestsThreeBeforeAndAfterSameOrder - thirdSetUp
[INFO ] 2018-08-19 22:58:28.897 [main] TwoTestsThreeBeforeAndAfterSameOrder - firstSetUp
[INFO ] 2018-08-19 22:58:28.897 [main] TwoTestsThreeBeforeAndAfterSameOrder - secondTest
[INFO ] 2018-08-19 22:58:28.897 [main] TwoTestsThreeBeforeAndAfterSameOrder - secondCleanUp
[INFO ] 2018-08-19 22:58:28.897 [main] TwoTestsThreeBeforeAndAfterSameOrder - firstCleanUp
[INFO ] 2018-08-19 22:58:28.897 [main] TwoTestsThreeBeforeAndAfterSameOrder - thirdCleanUp
[INFO ] 2018-08-19 22:58:28.898 [main] Framework - Executing tests from class [com.mlaptev.app.tests.TwoTestsThreeBeforeAndAfterDiffOrder]
[INFO ] 2018-08-19 22:58:28.899 [main] TwoTestsThreeBeforeAndAfterDiffOrder - constructor
[INFO ] 2018-08-19 22:58:28.901 [main] TwoTestsThreeBeforeAndAfterDiffOrder - secondSetUp
[INFO ] 2018-08-19 22:58:28.902 [main] TwoTestsThreeBeforeAndAfterDiffOrder - thirdSetUp
[INFO ] 2018-08-19 22:58:28.902 [main] TwoTestsThreeBeforeAndAfterDiffOrder - firstSetUp
[INFO ] 2018-08-19 22:58:28.902 [main] TwoTestsThreeBeforeAndAfterDiffOrder - firstTest
[INFO ] 2018-08-19 22:58:28.902 [main] TwoTestsThreeBeforeAndAfterDiffOrder - secondCleanUp
[INFO ] 2018-08-19 22:58:28.902 [main] TwoTestsThreeBeforeAndAfterDiffOrder - firstCleanUp
[INFO ] 2018-08-19 22:58:28.903 [main] TwoTestsThreeBeforeAndAfterDiffOrder - thirdCleanUp
[INFO ] 2018-08-19 22:58:28.903 [main] TwoTestsThreeBeforeAndAfterDiffOrder - constructor
[INFO ] 2018-08-19 22:58:28.903 [main] TwoTestsThreeBeforeAndAfterDiffOrder - secondSetUp
[INFO ] 2018-08-19 22:58:28.904 [main] TwoTestsThreeBeforeAndAfterDiffOrder - thirdSetUp
[INFO ] 2018-08-19 22:58:28.904 [main] TwoTestsThreeBeforeAndAfterDiffOrder - firstSetUp
[INFO ] 2018-08-19 22:58:28.904 [main] TwoTestsThreeBeforeAndAfterDiffOrder - secondTest
[INFO ] 2018-08-19 22:58:28.904 [main] TwoTestsThreeBeforeAndAfterDiffOrder - secondCleanUp
[INFO ] 2018-08-19 22:58:28.904 [main] TwoTestsThreeBeforeAndAfterDiffOrder - firstCleanUp
[INFO ] 2018-08-19 22:58:28.904 [main] TwoTestsThreeBeforeAndAfterDiffOrder - thirdCleanUp

Process finished with exit code 0
```

#### After applying ordering

```bash
"C:\Program Files\Java\jdk-10.0.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2018.1.5\lib\idea_rt.jar=61918:C:\Program Files\JetBrains\IntelliJ IDEA 2018.1.5\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Mikhail\Documents\Development\otus_java\hw41\target\classes;C:\Users\Mikhail\.m2\repository\org\apache\logging\log4j\log4j-api\2.11.0\log4j-api-2.11.0.jar;C:\Users\Mikhail\.m2\repository\org\apache\logging\log4j\log4j-core\2.11.0\log4j-core-2.11.0.jar com.mlaptev.app.App
[INFO ] 2018-08-19 22:59:13.494 [main] Framework - Executing tests from class [com.mlaptev.app.tests.SingleTest]
[INFO ] 2018-08-19 22:59:13.521 [main] SingleTest - constructor
[INFO ] 2018-08-19 22:59:13.522 [main] SingleTest - setUp
[INFO ] 2018-08-19 22:59:13.522 [main] SingleTest - firstTest
[INFO ] 2018-08-19 22:59:13.522 [main] SingleTest - cleanUp
[INFO ] 2018-08-19 22:59:13.524 [main] Framework - Executing tests from class [com.mlaptev.app.tests.TwoTests]
[INFO ] 2018-08-19 22:59:13.525 [main] TwoTests - constructor
[INFO ] 2018-08-19 22:59:13.525 [main] TwoTests - setUp
[INFO ] 2018-08-19 22:59:13.525 [main] TwoTests - firstTest
[INFO ] 2018-08-19 22:59:13.526 [main] TwoTests - cleanUp
[INFO ] 2018-08-19 22:59:13.526 [main] TwoTests - constructor
[INFO ] 2018-08-19 22:59:13.526 [main] TwoTests - setUp
[INFO ] 2018-08-19 22:59:13.526 [main] TwoTests - secondTest
[INFO ] 2018-08-19 22:59:13.526 [main] TwoTests - cleanUp
[INFO ] 2018-08-19 22:59:13.527 [main] Framework - Executing tests from class [com.mlaptev.app.tests.TwoTestsThreeBeforeAndAfterSameOrder]
[INFO ] 2018-08-19 22:59:13.529 [main] TwoTestsThreeBeforeAndAfterSameOrder - constructor
[INFO ] 2018-08-19 22:59:13.529 [main] TwoTestsThreeBeforeAndAfterSameOrder - thirdSetUp
[INFO ] 2018-08-19 22:59:13.529 [main] TwoTestsThreeBeforeAndAfterSameOrder - secondSetUp
[INFO ] 2018-08-19 22:59:13.529 [main] TwoTestsThreeBeforeAndAfterSameOrder - firstSetUp
[INFO ] 2018-08-19 22:59:13.529 [main] TwoTestsThreeBeforeAndAfterSameOrder - firstTest
[INFO ] 2018-08-19 22:59:13.529 [main] TwoTestsThreeBeforeAndAfterSameOrder - thirdCleanUp
[INFO ] 2018-08-19 22:59:13.530 [main] TwoTestsThreeBeforeAndAfterSameOrder - firstCleanUp
[INFO ] 2018-08-19 22:59:13.530 [main] TwoTestsThreeBeforeAndAfterSameOrder - secondCleanUp
[INFO ] 2018-08-19 22:59:13.530 [main] TwoTestsThreeBeforeAndAfterSameOrder - constructor
[INFO ] 2018-08-19 22:59:13.532 [main] TwoTestsThreeBeforeAndAfterSameOrder - thirdSetUp
[INFO ] 2018-08-19 22:59:13.532 [main] TwoTestsThreeBeforeAndAfterSameOrder - secondSetUp
[INFO ] 2018-08-19 22:59:13.533 [main] TwoTestsThreeBeforeAndAfterSameOrder - firstSetUp
[INFO ] 2018-08-19 22:59:13.533 [main] TwoTestsThreeBeforeAndAfterSameOrder - secondTest
[INFO ] 2018-08-19 22:59:13.533 [main] TwoTestsThreeBeforeAndAfterSameOrder - thirdCleanUp
[INFO ] 2018-08-19 22:59:13.533 [main] TwoTestsThreeBeforeAndAfterSameOrder - firstCleanUp
[INFO ] 2018-08-19 22:59:13.533 [main] TwoTestsThreeBeforeAndAfterSameOrder - secondCleanUp
[INFO ] 2018-08-19 22:59:13.534 [main] Framework - Executing tests from class [com.mlaptev.app.tests.TwoTestsThreeBeforeAndAfterDiffOrder]
[INFO ] 2018-08-19 22:59:13.535 [main] TwoTestsThreeBeforeAndAfterDiffOrder - constructor
[INFO ] 2018-08-19 22:59:13.536 [main] TwoTestsThreeBeforeAndAfterDiffOrder - firstSetUp
[INFO ] 2018-08-19 22:59:13.536 [main] TwoTestsThreeBeforeAndAfterDiffOrder - secondSetUp
[INFO ] 2018-08-19 22:59:13.536 [main] TwoTestsThreeBeforeAndAfterDiffOrder - thirdSetUp
[INFO ] 2018-08-19 22:59:13.536 [main] TwoTestsThreeBeforeAndAfterDiffOrder - firstTest
[INFO ] 2018-08-19 22:59:13.536 [main] TwoTestsThreeBeforeAndAfterDiffOrder - thirdCleanUp
[INFO ] 2018-08-19 22:59:13.536 [main] TwoTestsThreeBeforeAndAfterDiffOrder - secondCleanUp
[INFO ] 2018-08-19 22:59:13.536 [main] TwoTestsThreeBeforeAndAfterDiffOrder - firstCleanUp
[INFO ] 2018-08-19 22:59:13.540 [main] TwoTestsThreeBeforeAndAfterDiffOrder - constructor
[INFO ] 2018-08-19 22:59:13.540 [main] TwoTestsThreeBeforeAndAfterDiffOrder - firstSetUp
[INFO ] 2018-08-19 22:59:13.541 [main] TwoTestsThreeBeforeAndAfterDiffOrder - secondSetUp
[INFO ] 2018-08-19 22:59:13.541 [main] TwoTestsThreeBeforeAndAfterDiffOrder - thirdSetUp
[INFO ] 2018-08-19 22:59:13.541 [main] TwoTestsThreeBeforeAndAfterDiffOrder - secondTest
[INFO ] 2018-08-19 22:59:13.541 [main] TwoTestsThreeBeforeAndAfterDiffOrder - thirdCleanUp
[INFO ] 2018-08-19 22:59:13.541 [main] TwoTestsThreeBeforeAndAfterDiffOrder - secondCleanUp
[INFO ] 2018-08-19 22:59:13.541 [main] TwoTestsThreeBeforeAndAfterDiffOrder - firstCleanUp

Process finished with exit code 0

```

#### Covering exception in functions annotated by `@test` annotation

```bash
[INFO ] 2018-08-20 22:35:32.509 [main] Framework - Executing tests from class [com.mlaptev.app.tests.SingleTestWithException]
[INFO ] 2018-08-20 22:35:32.510 [main] SingleTestWithException - constructor
[INFO ] 2018-08-20 22:35:32.510 [main] SingleTestWithException - setUp
[ERROR] 2018-08-20 22:35:32.511 [main] Framework - Exception occurs during test execution.
java.lang.reflect.InvocationTargetException: null
	at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:?]
	at jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[?:?]
	at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[?:?]
	at java.lang.reflect.Method.invoke(Method.java:564) ~[?:?]
	at com.mlaptev.app.framework.Framework.executeTest(Framework.java:57) [classes/:?]
	at com.mlaptev.app.App.main(App.java:19) [classes/:?]
Caused by: java.lang.NullPointerException: Example of exception.
	at com.mlaptev.app.tests.SingleTestWithException.firstTest(SingleTestWithException.java:24) ~[classes/:?]
	... 6 more
[INFO ] 2018-08-20 22:35:32.739 [main] SingleTestWithException - cleanUp
``` 