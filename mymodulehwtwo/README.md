### Results 



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