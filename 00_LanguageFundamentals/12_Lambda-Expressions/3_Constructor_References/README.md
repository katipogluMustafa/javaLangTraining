# Constructor References

* Constructor references are just like method references, except that the name of the method is new. 
    
    * For example, Person::new is a reference to a Person constructor. 
    
    * Which constructor? It depends on the context. 
    
    * Suppose you have a list of strings. Then you can turn it into an array of Person objects, by calling the constructor on each of the strings, with the following invocation:
```java
ArrayList<String> names = . . .;
Stream<Person> stream = names.stream().map(Person::new);
List<Person> people = stream.collect(Collectors.toList());
```

* The map method calls the Person(String) constructor for each list element. 
    
    * If there are multiple Person constructors, the compiler picks the one with a String parameter because it infers from the context that the constructor is called with a string.

* You can form constructor references with array types. 

    * For example, `int[]::new` is a constructor reference with one parameter: the length of the array. 
        * It is equivalent to the lambda expression x -> new int[x].

* Array constructor references are useful to overcome a limitation of Java. It is not possible to construct an array of a generic type T. 
    * For example, suppose we want to have an array of Person objects. The Stream interface has a toArray method that returns an Object array:

        ```java
        Object[] people = stream.toArray();
        ```

    * But that is unsatisfactory. The user wants an array of references to Person, not references to Object. 
    * The stream library solves that problem with constructor references. Pass Person[]::new to the toArray method:
        ```java
        Person[] people = stream.toArray(Person[]::new);
        ```
    * The toArray method invokes this constructor to obtain an array of the correct type. Then it fills and returns the array.