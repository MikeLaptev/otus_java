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

...

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

#### maven + jar-with-dependencies
```bash
C:\Users\Mikhail\Documents\Development\otus_java>mvn package assembly:single
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO]
[INFO] my-app
[INFO] my-module-hw-one
[INFO]

...

[INFO] --- maven-assembly-plugin:3.1.0:single (default-cli) @ my-module-hw-one ---
[INFO] Building jar: C:\Users\Mikhail\Documents\Development\otus_java\mymodulehwone\target\hw-one-jar-with-dependencies.jar
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] my-app ............................................. SUCCESS [  1.241 s]
[INFO] my-module-hw-one ................................... SUCCESS [  7.125 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 8.940 s
[INFO] Finished at: 2018-07-01T11:32:48+01:00
[INFO] Final Memory: 18M/64M
[INFO] ------------------------------------------------------------------------
```

#### Launch of the jar with dependencies
```bash
C:\Users\Mikhail\Documents\Development\otus_java>java -jar ./mymodulehwone/target/hw-one-jar-with-dependencies.jar
20 3 6 80
[INFO ] 2018-07-01 12:13:23.236 [main] HalloweenSale - Maximum number of games: 6
```

#### Obfuscation

##### Build 

```bash
C:\Users\Mikhail\Documents\Development\otus_java>mvn package assembly:single
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
[INFO] --- maven-assembly-plugin:3.1.0:single (default-cli) @ my-app ---
[INFO] Assemblies have been skipped per configuration of the skipAssembly parameter.

...

 [proguard] Note: the configuration keeps the entry point 'org.apache.logging.log4j.core.util.datetime.FixedDateFormat$FixedFormat { int access$300(org.apache.logging.log4j.core.util.datetime.FixedDateFormat$FixedFormat); }', but not the descriptor class 'org.apache.logging.log4j.core.util.datetime.FixedDateFormat$FixedFormat'
 [proguard] Note: there were 18 classes trying to access annotations using reflection.
 [proguard]       You should consider keeping the annotation attributes
 [proguard]       (using '-keepattributes *Annotation*').
 [proguard]       (http://proguard.sourceforge.net/manual/troubleshooting.html#attributes)
 [proguard] Note: there were 10 classes trying to access generic signatures using reflection.
 [proguard]       You should consider keeping the signature attributes
 [proguard]       (using '-keepattributes Signature').
 [proguard]       (http://proguard.sourceforge.net/manual/troubleshooting.html#attributes)
 [proguard] Note: there were 55 unkept descriptor classes in kept class members.
 [proguard]       You should consider explicitly keeping the mentioned classes
 [proguard]       (using '-keep').
 [proguard]       (http://proguard.sourceforge.net/manual/troubleshooting.html#descriptorclass)
 [proguard] Note: there were 20 accesses to class members by means of introspection.
 [proguard]       You should consider explicitly keeping the mentioned class members
 [proguard]       (using '-keep' or '-keepclassmembers').
 [proguard]       (http://proguard.sourceforge.net/manual/troubleshooting.html#dynamicalclassmember)
 [proguard] Preparing output jar [C:\Users\Mikhail\Documents\Development\otus_java\mymodulehwone\target\hw-one-jar-with-dependencies-small.jar]
 [proguard]   Copying resources from program jar [C:\Users\Mikhail\Documents\Development\otus_java\mymodulehwone\target\hw-one-jar-with-dependencies.jar] (filtered)
[INFO]
[INFO] --- maven-assembly-plugin:3.1.0:single (default-cli) @ my-module-hw-one ---
[INFO] Building jar: C:\Users\Mikhail\Documents\Development\otus_java\mymodulehwone\target\hw-one-jar-with-dependencies.jar
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] my-app ............................................. SUCCESS [  1.564 s]
[INFO] my-module-hw-one ................................... SUCCESS [ 16.909 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 19.088 s
[INFO] Finished at: 2018-07-02T23:28:50+01:00
[INFO] Final Memory: 19M/70M
[INFO] ------------------------------------------------------------------------
```

##### Execution

```bash
C:\Users\Mikhail\Documents\Development\otus_java>java -jar .\mymodulehwone\target\hw-one-jar-with-dependencies-small.jar
ERROR StatusLogger Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...
20 6 3 80

C:\Users\Mikhail\Documents\Development\otus_java>
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
<option>-keepclassmembers class * extends java.lang.Enum {
    *;
  }
</option>
```

**Issue 2**
```bash
C:\Users\Mikhail\Documents\Development\otus_java>java -jar .\mymodulehwone\target\hw-one-jar-with-dependencies-small.jar
ERROR StatusLogger Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...
```

**Solution**
TODO(mikhail.laptev): to identify how to use log4j properly...