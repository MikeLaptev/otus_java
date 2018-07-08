### Results

#### mvn package

```bash
C:\Users\Mikhail\Documents\Development\otus_java>mvn package
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO]
[INFO] my-app
[INFO] my-module-hw-one
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building my-app 1.0
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building my-module-hw-one 1.0

...

[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.mlaptev.app.HalloweenSaleTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 12.156 s - in com.mlaptev.app.HalloweenSaleTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:3.1.0:jar (default-jar) @ my-module-hw-one ---
[INFO] Building jar: C:\Users\Mikhail\Documents\Development\otus_java\mymodulehwone\target\hw-one.jar
[INFO]
[INFO] --- maven-assembly-plugin:3.1.0:single (my-module-hw-one-assembly) @ my-module-hw-one ---
[INFO] Building jar: C:\Users\Mikhail\Documents\Development\otus_java\mymodulehwone\target\hw-one-jar-with-dependencies.jar
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] my-app ............................................. SUCCESS [  0.012 s]
[INFO] my-module-hw-one ................................... SUCCESS [01:55 min]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 01:55 min
[INFO] Finished at: 2018-07-08T11:49:39+01:00
[INFO] Final Memory: 23M/84M
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
[INFO ] 2018-07-08 11:52:41.361 [main] HalloweenSale - Maximum number of games: 6
```

#### java -jar <jar>
```bash
C:\Users\Mikhail\Documents\Development\otus_java>java -jar ./mymodulehwone/target/hw-one.jar
Exception in thread "main" java.lang.NoClassDefFoundError: org/apache/logging/log4j/LogManager
        at com.mlaptev.app.HalloweenSale.<clinit>(HalloweenSale.java:14)
Caused by: java.lang.ClassNotFoundException: org.apache.logging.log4j.LogManager
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(Unknown Source)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(Unknown Source)
        at java.base/java.lang.ClassLoader.loadClass(Unknown Source)
        ... 1 more
```

#### java -jar <jar-with-dependencies>
```bash
C:\Users\Mikhail\Documents\Development\otus_java>java -jar ./mymodulehwone/target/hw-one-jar-with-dependencies.jar
20 3 6 80
[INFO ] 2018-07-08 11:53:58.871 [main] HalloweenSale - Maximum number of games: 6
```

#### Obfuscation

##### Build 

```bash
C:\Users\Mikhail\Documents\Development\otus_java>mvn package
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO]
[INFO] my-app
[INFO] my-module-hw-one
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building my-app 1.0
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building my-module-hw-one 1.0
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ my-module-hw-one ---

...

 [proguard] Preparing output jar [C:\Users\Mikhail\Documents\Development\otus_java\mymodulehwone\target\hw-one-jar-with-dependencies-small.jar]
 [proguard]   Copying resources from program jar [C:\Users\Mikhail\Documents\Development\otus_java\mymodulehwone\target\hw-one-jar-with-dependencies.jar] (filtered)
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] my-app ............................................. SUCCESS [  0.011 s]
[INFO] my-module-hw-one ................................... SUCCESS [01:20 min]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 01:20 min
[INFO] Finished at: 2018-07-08T11:58:57+01:00
[INFO] Final Memory: 23M/80M
[INFO] ------------------------------------------------------------------------
```

##### Execution

```bash
C:\Users\Mikhail\Documents\Development\otus_java>java -jar ./mymodulehwone/target/hw-one-jar-with-dependencies-small.jar
20 3 6 80
[INFO ] 2018-07-08 13:14:05.562 [main] HalloweenSale - Maximum number of games: 6
```

##### Changes in size of final jar
```bash
07/08/2018  13:12         1,385,497 hw-one-jar-with-dependencies-small.jar
07/08/2018  13:12         1,855,547 hw-one-jar-with-dependencies.jar
```

##### Pitfalls

**Issue 1**:
```bash
C:\Users\Mikhail\Documents\Development\otus_java>java -jar .\mymodulehwone\target\hw-one-jar-with-dependencies-small.jar
Exception in thread "main" java.lang.ExceptionInInitializerError
        at a.a.a.a.a.<clinit>(Unknown Source)
        at a.a.a.a.d.b.<init>(Unknown Source)
        at a.a.a.a.d.b.<clinit>(Unknown Source)
        at a.a.a.a.b.<clinit>(Unknown Source)
        at com.mlaptev.app.HalloweenSale.<clinit>(Unknown Source)
Caused by: java.lang.ClassCastException: class a.a.a.a.c.r not an enum
        at java.base/java.util.EnumSet.noneOf(Unknown Source)
        at java.base/java.util.EnumSet.allOf(Unknown Source)
        at a.a.a.a.c.r.<clinit>(Unknown Source)
        ... 5 more
```
**Solution**
To add following configuration to pom.xml
```xml
<option>-keepclassmembers class * extends java.lang.Enum { *; }</option>
```

**Issue 2**
```bash
C:\Users\Mikhail\Documents\Development\otus_java>java -jar .\mymodulehwone\target\hw-one-jar-with-dependencies-small.jar
ERROR StatusLogger Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...
```

**Solution**
```xml
<option>-keepattributes Signature</option>
<option>-keepattributes *Annotation*</option>
<option>-keep class org.apache.logging.log4j.** { *; }</option>
<option>-dontoptimize</option>
```