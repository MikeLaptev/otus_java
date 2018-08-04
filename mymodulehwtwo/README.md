### Results 

#### Class with one primitive double
A variable of type `double` requires - 8 bytes
```bash
[INFO ] 2018-08-04 17:23:04.115 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 17:23:04.117 [main] GetSizeOfTheObject - Memory for object: 24
```

#### Class with two empty strings
```bash
[INFO ] 2018-08-04 17:23:08.488 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 17:23:08.488 [main] GetSizeOfTheObject - Memory for object: 24
```

#### Class with two integers
##### Initialized to 127 (Byte.MAX_BYTE) and -128 (Byte.MIN_BYTE)
```bash
[INFO ] 2018-08-04 17:45:05.167 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 17:45:05.174 [main] GetSizeOfTheObject - Memory for object: 24
```
##### Initialized to 128 and -128
```bash
[INFO ] 2018-08-04 17:45:41.056 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 17:45:41.058 [main] GetSizeOfTheObject - Memory for object: 40
```
##### Initialized to 127 and -129
```bash
[INFO ] 2018-08-04 17:46:11.998 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 17:46:12.001 [main] GetSizeOfTheObject - Memory for object: 40
```
##### Initialized to 128 (Byte.MAX_BYTE + 1) and -129 (Byte.MIN_BYTE - 1)
```bash
[INFO ] 2018-08-04 17:46:39.195 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 17:46:39.197 [main] GetSizeOfTheObject - Memory for object: 56
```

#### Class with two primitive integers
A variable of type `int` requires 4 bytes
```bash
[INFO ] 2018-08-04 17:23:16.927 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 17:23:16.927 [main] GetSizeOfTheObject - Memory for object: 24
```

#### Empty string
```bash
[INFO ] 2018-08-04 17:23:21.024 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 17:23:21.024 [main] GetSizeOfTheObject - Memory for object: 0
```

#### Randomly generated UUID (128-bit)
```bash
[INFO ] 2018-08-04 17:23:27.847 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 17:23:27.847 [main] GetSizeOfTheObject - Memory for object: 80
```

#### ArrayList
```bash
[INFO ] 2018-08-04 17:23:32.096 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 17:23:32.096 [main] GetSizeOfTheObject - Memory for object: 24
```

#### Randomly generated integer
```bash
[INFO ] 2018-08-04 17:23:36.359 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 17:23:36.359 [main] GetSizeOfTheObject - Memory for object: 16
```

### Memory for object == -4:
```bash
[INFO ] 2018-08-04 18:10:42.806 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 18:10:42.806 [main] GetSizeOfTheObject - Memory for object: -4
```

I've replaced `size` with `array.length` in the snippet below:
```java
public class GetSizeOfTheObject {
  
  public static <T> long getSizeOfTheObjectUsingLoop(Supplier<T> initializer) throws InterruptedException {

    for (int i = 0; i < size; i++) {
      array[i] = initializer.get();
    }

    long memAfterInitialization = getCurrentMemory();

    long memoryForReference = (memAfterArrayCreation - memBefore)/size;
    logger.info("Memory for reference: {}", memoryForReference);

    long memoryForObject = (memAfterInitialization - memAfterArrayCreation)/size;
    logger.info("Memory for object: {}", memoryForObject);
  }
}
```
so, finally source code was like that
```java
public class GetSizeOfTheObject {
  
  public static <T> long getSizeOfTheObjectUsingLoop(Supplier<T> initializer) throws InterruptedException {

    for (int i = 0; i < array.length; i++) {
      array[i] = initializer.get();
    }

    long memAfterInitialization = getCurrentMemory();

    long memoryForReference = (memAfterArrayCreation - memBefore)/array.length;
    logger.info("Memory for reference: {}", memoryForReference);

    long memoryForObject = (memAfterInitialization - memAfterArrayCreation)/array.length;
    logger.info("Memory for object: {}", memoryForObject);
  }
}
```
and I've got 
```bash
[INFO ] 2018-08-04 18:12:27.896 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-04 18:12:27.896 [main] GetSizeOfTheObject - Memory for object: 24
```