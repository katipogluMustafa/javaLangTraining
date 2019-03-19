# Functional Interfaces

You can supply a lambda expression whenever an object of an interface with a single abstract method is expected. 

* Such an interface is called a **functional interface**.

> You may wonder why a functional interface must have a single abstract method. <br> Aren’t all methods in an interface abstract? <br> Actually, it has always been possible for an interface to redeclare methods from the Object class such as toString or clone, and these declarations do not make the methods abstract. <br> as you saw in  “Default Methods” , interfaces can declare nonabstract methods.

* Consider the Arrays.sort method. 
    * Its second parameter requires an instance of Comparator, an interface with a single method. 
    * Simply supply a lambda:
    ```java
      Arrays.sort(words, (first, second) -> first.length - second.length );    
    ```
    * Behind the scenes, the Arrays.sort method receives an object of some class that implements Comparator<String>. 
    * Invoking the compare method on that object executes the body of the lambda expression.

* This conversion to interfaces is what makes lambda expressions so compelling. The syntax is short and simple.
```
var timer = new Timer(1000, event -> 
   {
      System.out.println("At the tone, the time is "
         + Instant.ofEpochMilli(event.getWhen()));
      Toolkit.getDefaultToolkit().beep();
   });
//  Easier to read than the alternative with a class that implements the ActionListener interface.
```

* In fact, conversion to a functional interface is the only thing that you can do with a lambda expression in Java.

> You can’t even assign a lambda expression to a variable of type Object—Object is not a functional interface.

* The Java API defines a number of very generic functional interfaces in the java.util.function package. 
    * One of the interfaces, BiFunction<T, U, R>, describes functions with parameter types T and U and return type R. 
    * You can save our string comparison lambda in a variable of that type:
    ```java
      BiFunction<String, String, Integer> comp = (first, second) first.length() - second.length();
    ```
    * However, that does not help you with sorting. There is no Arrays.sort method that wants a BiFunction.

* An interface such as Comparator has a specific purpose, not just a method with given parameter and return types. 
    * When you want to do something with lambda expressions, you still want to keep the purpose of the expression in mind, and have a specific functional interface for it.
 
 * A particularly useful interface in the java.util.function package is Predicate:
    ```java
    public interface Predicate<T>
    {
       boolean test(T t);
       // additional default and static methods
    }
    ```
    
* The ArrayList class has a removeIf method whose parameter is a Predicate. 
    * It is specifically designed to pass a lambda expression. 
    * For example, the following statement removes all null values from an array list:
        ```java
        list.removeIf(e -> e == null);
        ```
* Another useful functional interface is Supplier<T>:
  ```java
  public interface Supplier<T>
  {
     T get();
  }  
  ```
   * A supplier has no arguments and yields a value of type T when it is called. 
   * Suppliers are used for lazy evaluation. For example, consider the call
       ```java
      LocalDate hireDay = Objects.requireNonNullOrElse(day,
           new LocalDate(1970, 1, 1));
       ```
   * This is not optimal. We expect that day is rarely null, so we only want to construct the default LocalDate when necessary. 
   * By using the supplier, we can defer the computation:
        ```java
        LocalDate hireDay = Objects.requireNonNullOrElseGet(day,
         () -> new LocalDate(1970, 1, 1));  
        ```

  * The **requireNonNullOrElseGet method only calls the supplier when the value is needed**.
  