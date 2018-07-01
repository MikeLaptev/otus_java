### Results

#### mvn package

```bash
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:3.1.0:jar (default-jar) @ my-module-hw-one ---
[INFO] Building jar: C:\Users\Mikhail\Documents\Development\otus_java\mymodulehwone\target\hw-one.jar
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] my-app ............................................. SUCCESS [  0.006 s]
[INFO] my-module-hw-one ................................... SUCCESS [ 34.225 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 34.586 s
[INFO] Finished at: 2018-07-01T00:43:46+01:00
[INFO] Final Memory: 11M/47M
[INFO] ------------------------------------------------------------------------
```

#### java -cp + jar + class
```bash
C:\Users\Mikhail\Documents\Development\otus_java>java -cp ./mymodulehwone/target/hw-one.jar com.mlaptev.app.HalloweenSale
Exception in thread "main" java.lang.NoClassDefFoundError: org/apache/logging/log4j/LogManager
        at com.mlaptev.app.HalloweenSale.<clinit>(HalloweenSale.java:14)
Caused by: java.lang.ClassNotFoundException: org.apache.logging.log4j.LogManager
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(Unknown Source)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(Unknown Source)
        at java.base/java.lang.ClassLoader.loadClass(Unknown Source)
        ... 1 more
```

#### java -cp + jar + dependency + class
```bash
C:\Users\Mikhail\Documents\Development\otus_java>java -cp ./mymodulehwone/target/hw-one.jar;C:\Users\Mikhail\.m2\repository\org\apache\logging\log4j\log4j-api\2.11.0\log4j-api-2.11.0.jar;C:\Users\Mikhail\.m2\repository\org\apache\logging\log4j\log4j-core\2.11.0\log4j-core-2.11.0.jar com.mlaptev.app.HalloweenSale
20 3 6 80
[INFO ] 2018-07-01 00:51:26.869 [main] HalloweenSale - Maximum number of games: 6
```