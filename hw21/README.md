### Results 

#### Object of an empty class
```bash
[INFO ] 2018-08-05 15:01:13.110 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:01:13.112 [main] GetSizeOfTheObject - Memory for object: 16
```

#### Object of a class with only one variable of `byte` type
```bash
[INFO ] 2018-08-05 15:01:17.762 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:01:17.762 [main] GetSizeOfTheObject - Memory for object: 16
```

#### Object of a class with only one variable of `int` type
```bash
[INFO ] 2018-08-05 15:01:22.421 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:01:22.421 [main] GetSizeOfTheObject - Memory for object: 16
```

#### Object of a class with two variables of `int` type
```bash
[INFO ] 2018-08-05 15:01:27.112 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:01:27.112 [main] GetSizeOfTheObject - Memory for object: 24
```

#### Object of a class with one variable of `double` type
```bash
[INFO ] 2018-08-05 15:01:31.812 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:01:31.812 [main] GetSizeOfTheObject - Memory for object: 24
```

#### Object of a class with two `String` variables initialized by the empty string `""`
```bash
[INFO ] 2018-08-05 15:01:36.765 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:01:36.765 [main] GetSizeOfTheObject - Memory for object: 24
```

#### Object of a class with two `Integer` variables that initialized by values that pre-cached by JVM
```bash
[INFO ] 2018-08-05 15:01:41.775 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:01:41.775 [main] GetSizeOfTheObject - Memory for object: 24
```

#### Object of a class with two `Integer` variables that initialized by values that outside of cached by JVM range
```bash
[INFO ] 2018-08-05 15:01:47.131 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:01:47.131 [main] GetSizeOfTheObject - Memory for object: 56
```

#### Object of a class with one `Double` variable
```bash
[INFO ] 2018-08-05 15:01:52.149 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:01:52.149 [main] GetSizeOfTheObject - Memory for object: 40
```

#### Object of a class with two `Double` variables
```bash
[INFO ] 2018-08-05 15:01:57.673 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:01:57.673 [main] GetSizeOfTheObject - Memory for object: 72
```

#### Object of a class with three `Double` variables
```bash
[INFO ] 2018-08-05 15:02:03.617 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:02:03.617 [main] GetSizeOfTheObject - Memory for object: 96
```

#### Just `""` variable
```bash
[INFO ] 2018-08-05 15:02:07.891 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:02:07.891 [main] GetSizeOfTheObject - Memory for object: 0
```

#### Example from the lecture `new String("")`
```bash
[INFO ] 2018-08-05 15:02:12.682 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:02:12.682 [main] GetSizeOfTheObject - Memory for object: 24
```

#### Another example from the lecture `new String(new byte[0])`
```bash
[INFO ] 2018-08-05 15:02:17.899 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:02:17.899 [main] GetSizeOfTheObject - Memory for object: 40
```

#### `new String(new byte[10])`
```bash
[INFO ] 2018-08-05 15:02:23.333 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:02:23.333 [main] GetSizeOfTheObject - Memory for object: 56
```

#### `new String(new byte[16])`
```bash
[INFO ] 2018-08-05 15:02:28.903 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:02:28.903 [main] GetSizeOfTheObject - Memory for object: 56
```

#### `new String(new byte[17])`
```bash
[INFO ] 2018-08-05 15:02:34.503 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:02:34.503 [main] GetSizeOfTheObject - Memory for object: 64
```

#### Generating of random 128 bit UUID
```bash
[INFO ] 2018-08-05 15:02:50.178 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:02:50.178 [main] GetSizeOfTheObject - Memory for object: 80
```

#### Empty `ArrayList<Integer>()`
```bash
[INFO ] 2018-08-05 15:02:55.139 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:02:55.139 [main] GetSizeOfTheObject - Memory for object: 24
```

#### Array of 10 elements of type `int` 
```bash
[INFO ] 2018-08-05 15:02:59.988 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:02:59.988 [main] GetSizeOfTheObject - Memory for object: 56
```

#### Randomly generated `int`
```bash
[INFO ] 2018-08-05 15:03:05.016 [main] GetSizeOfTheObject - Memory for reference: 4
[INFO ] 2018-08-05 15:03:05.016 [main] GetSizeOfTheObject - Memory for object: 16
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