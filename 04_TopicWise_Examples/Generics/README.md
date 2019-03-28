# Generic Programming

* Type parameters bring compile time safety.

## Generic Classes

* Skeleton of Generic Class
````java
public class Pair<T> {
    private T first;
    private T second;
    public Pair(){ this.first = null;   this.second = null;  }
    public Pair(T first, T second){this.first = first; this.second = second; }
    public T getFirst(){ return this.first; }
    public T getSecond(){return this.second; }
    public void setFirst(T first){ this.first = first; }
    public void setSecond(T second){ this.second = second; }

}
````

* Let's create a Pair<String>
````java
    Pair<String> point = new Pair<>();
````
## Generic Methods

* You can have generic methods in non-generic classes.

* Put the generic type declaration after modifiers before the return type.

````java
public class MyClass{
    public static <T> T getMiddle(T... a){
        return a[a.length /2];
    }  
}
````

* Let's call getMiddle method
    ````java
        String middle = MyClass.<String>getMiddle("Mustafa", "Katipoglu", "was", "here", ".");
    ````
    * The actual type comes before the method name.

* You rarely need to call it this way, java compiler can infer the type.
    ````java
      String middle = MyClass.getMiddle("Mustafa", "Katipoglu", "was", "here", ".");
    ````
    * Works fine
    
    * Occasionally something goes wrong
    ````java
      Double middle = MyClass.getMiddle(15.2,23.4,0); 
      // gives error since JC confused because of 0 is int
      Double middle = MyClass.getMiddle(15.2,23.4,0.0);       // solves the problem 
    ````
    
## Type Bound

````java
public static <T extends Comparable> T min(T[] a) ...
````

* By using this notation we can say that we accept type T which implements Comparable but be careful we use extends keyword whether it is interface or class.

* You can have more than one bound, separate with &

* As with Java inheritance, you can have as many interface supertypes as you like, but at most one of the bounds can be a class. If you have a class as a bound, it must be the first one in the bounds list.


````java
public static <T extends Comparable & Cloneable> T min(T[] a) ...
````
* Example
    ````java
        public static void main(String[] args) {
            LocalDate[] birthdays =
                    {
                            LocalDate.of(1906,12,9),
                            LocalDate.of(1815,12,10),
                            LocalDate.of(1903,12,3),
                            LocalDate.of(1910,6,22),
                    };
            Pair<LocalDate> minMax = minmax(birthdays);
            System.out.println("Min: " + minMax.getFirst() + "\nMax: " + minMax.getSecond());
        }
    
        public static <T extends Comparable> Pair<T> minmax(T[] a) {
            if( a == null || a.length == 0) return null;
            T min = a[0];
            T max = a[1];
            for(T e : a)
                if(min.compareTo(e) > 0)
                    min = e;
                else if( max.compareTo(e) < 0)
                    max = e;
            return new Pair<>(min,max);
        }
    ````

## GENERIC CODE AND THE VIRTUAL MACHINE

### Type Erasure

* Whenever you define a generic type, a corresponding raw type is automatically provided.

* The name of the raw type is simply the name of the generic type, with the type parameters removed. The type variables are erased and replaced by their bounding types 

* The raw type replaces type variables with the first bound, or Object if no bounds are given.

* Suppose we declare
    ````java
      public class Interval<T extends Comparable & Serializable> implements Serializable
      {
         private T lower;
         private T upper;
         . . .
         public Interval(T first, T second)
         {
            if (first.compareTo(second) <= 0) { lower = first; upper = second; }
            else { lower = second; upper = first; }
         }
      }
    ````  
    
    * The raw type Interval looks like this:
    ````java
      public class Interval implements Serializable
      {
         private Comparable lower;
         private Comparable upper;
         . . .
         public Interval(Comparable first, Comparable second) { . . . }
      }
    ````

> You may wonder what happens if you switch the bounds: class Interval<T extends Serializable & Comparable>. In that case, the raw type replaces T with Serializable, and the compiler inserts casts to Comparable when necessary. For efficiency, you should therefore put tagging interfaces (that is, interfaces without methods) at the end of the bounds list.

* In summary, you need to remember these facts about translation of Java generics:

    * There are no generics in the virtual machine, only ordinary classes and methods.

    * All type parameters are replaced by their bounds.

    * Bridge methods are synthesized to preserve polymorphism.

    * Casts are inserted as necessary to preserve type safety.

### Calling Legacy Code

* Review the warning and make sure that the label table really contains Integer and Component objects.

*  Of course, there never is an absolute guarantee. A malicious coder might have installed a different Dictionary in the slider. But again, the situation is no worse than it was before generics.

````java
@SuppressWarnings("unchecked")
Dictionary<Integer, Components> labelTable = slider.getLabelTable(); // no warning
````

* Then use SuppressWarnings annotation.
    
## RESTRICTIONS AND LIMITATIONS

### Type Parameters Cannot Be Instantiated with Primitive Types

You cannot substitute a primitive type for a type parameter. 

*  Thus, there is no Pair<double>, only Pair<Double>. 

* The reason is, of course, type erasure. After erasure, the Pair class has fields of type Object, and you can’t use them to store double values.


### Runtime Type Inquiry Only Works with Raw Types

Objects in the virtual machine always have a specific nongeneric type. Therefore, all type inquiries yield only the raw type.

````java
if (a instanceof Pair<String>) // ERROR
...

if (a instanceof Pair<T>) // ERROR    
...    
````

* Or the cast

````java
Pair<String> p = (Pair<String>) a; // warning--can only test that a is a Pair
````

* The getClass method always returns the raw type.
````java
Pair<String> stringPair = . . .;
Pair<Employee> employeePair = . . .;
if (stringPair.getClass() == employeePair.getClass()) // they are equal
````
* The comparison yields true because both calls to getClass return Pair.class.

### You Cannot Create Arrays of Parameterized Types

You cannot instantiate arrays of parameterized types, such as
````java
var table = new Pair<String>[10]; // ERROR
````

* What’s wrong with that? After erasure, the type of table is Pair[]. You can convert it to Object[]:
````java
Object[] objarray = table;
````
* An array remembers its component type and throws an ArrayStoreException if you try to store an element of the wrong type
````java
objarray[0] = "Hello"; // ERROR--component type is Pair
````

*  For this reason, arrays of parameterized types are outlawed.

* Note that only the creation of these arrays is outlawed. 
    * You can declare a variable of type `Pair<String>[]`. 
    * But you can’t initialize it with a new `Pair<String>[10]`.

---

#### Note
You can declare arrays of wildcard types and then cast them:

````java
var table = (Pair<String>[]) new Pair<?>[10];
````

* The result is not safe. 
    * If you store a `Pair<Employee>` in table[0] and then call a String method on table[0].getFirst(), you get a ClassCastException.

* If you need to collect parameterized type objects, simply use an ArrayList: `ArrayList<Pair<String>>` is safe and effective.


---

#### Varargs Warnings

**issue**: passing instances of a generic type to a method with a variable number of arguments.

* Consider this simple method with variable arguments:
    ````java
    public static <T> void addAll(Collection<T> coll, T... ts)
    {
       for (T t : ts) coll.add(t);
    }
    ````

    * Recall that the parameter ts is actually an array that holds all supplied arguments.

* In order to call this method, the Java virtual machine must make an array of Pair<String>, which is against the rules. 
    * However, the rules have been relaxed for this situation, and you only get a warning, not an error.

* You can suppress the warning in one of two ways.
    * You can add the annotation `@SuppressWarnings("unchecked")` to the method containing the call to addAll.
    * Or, as of Java 7, you can annotate the addAll method itself with `@SafeVarargs`

        ````java
        @SafeVarargs
        public static <Tt> void addAll(Collection<T> coll, T... ts)
        ````
        
        * This method can now be called with generic types. 
    * You can use this annotation for any methods that merely read the elements of the parameter array, which is bound to be the most common use case.
    * The **@SafeVarargs** can only be used with constructors and methods that are **static, final, or (as of Java 9) private**. 
        * Any other method could be overridden, making the annotation meaningless.    
        

### You Cannot Instantiate Type Variables

* You cannot use type variables in an expression such as new T(. . .).
    ````java
      public Pair() { first = new T(); second = new T(); } // ERROR
    ````
* Type erasure would change T to Object, and surely you don’t want to call new Object().
  
* The best workaround, available since Java 8, is to make the caller provide a constructor expression. 
    ````java
      Pair<String> p = Pair.makePair(String::new);
    ````
    ````java
      public static <T> Pair<T> makePair(Supplier<T> constr)
      {
         return new Pair<>(constr.get(), constr.get());
      }
    ````

* A more traditional workaround is to construct generic objects through reflection, by calling the Constructor.newInstance method.
    ````java
      Pair<String> p = Pair.makePair(String.class);
    ````
    ````java
      public static <T> Pair<T> makePair(Class<T> cl)
      {
         try {
            return new Pair<>(cl.getConstructor().newInstance(),
               cl.getConstructor().newInstance());
         }
         catch (Exception e) { return null; }
      }
    ````

###  You Cannot Construct a Generic Array

* Just as you cannot instantiate a single generic instance, you cannot instantiate an array.
    ````java
    public static <T extends Comparable> T[] minmax(T... a) 
    { 
       T[] mm = new T[2]; // ERROR
       . . . 
    }
    // Type erasure would cause this method to always construct an array Comparable[2]. 
    ````

* In this situation, it is best to ask the user to provide an array constructor expression:
    ````java
        String[] names = ArrayAlg.minmax(String[]::new, "Tom", "Dick", "Harry");
    ````
    ````java
      public static <T extends Comparable> T[] minmax(IntFunction<T[]> constr, T... a)
      {
         T[] result = constr.apply(2);    // create result array
         . . .
      }
    ````
    
    * Remember
        ````java
          @FunctionalInterface
          public interface IntFunction<R> {  
              R apply(int value);
          }
        ````
* A more old-fashioned approach is to use reflection and call Array.newInstance:
    ````java
      public static <T extends Comparable> T[] minmax(T... a)
      {
         var result = (T[]) Array.newInstance(a.getClass().getComponentType(), 2);
         . . .
      }
    ````

#### toArray method of ArrayList class

* The toArray method of the ArrayList class is not so lucky. 
    * It needs to produce a T[] array, but it doesn’t have the component type. Therefore, there are two variants:
        * Object[] toArray()
        * T[] toArray(T[] result)

    * The second method receives an array parameter. 
        * If the array is large enough, it is used. 
        * Otherwise, a new array of sufficient size is created, using the component type of result.

### Type Variables Are Not Valid in Static Contexts of Generic Classes

* You cannot reference type variables in static fields or methods. For example, the following clever idea won’t work.
    ````java
      public class Singleton<T>
      {
         private static T singleInstance; // ERROR
         public static T getSingleInstance() // ERROR
         {
            if (singleInstance == null) construct new instance of T
            return singleInstance;
         }
      }
    ````
*  After type erasure there is only one Singleton class, and only one singleInstance field. 

* For that reason, **static fields and methods with type variables are simply outlawed**.

### You Cannot Throw or Catch Instances of a Generic Class

You can neither throw nor catch objects of a generic class. 

* In fact, it is not even legal for a generic class to extend Throwable.

````java
public class Problem<T> extends Exception { /* . . . */ } 
   // ERROR--can't extend Throwable
````

* You cannot use a type variable in a catch clause. 
    ````java
      public static <T extends Throwable> void doWork(Class<T> t)
      {
         try
         {
            do work
         }
         catch (T e) // ERROR--can't catch type variable
         {
            Logger.global.info(. . .);
         }
      }
    ````

* However, it is OK to use type variables in exception specifications.




## Notes

* Since type variables are erased to Object, they don't work for primitive types.

* instanceof test only works with raw types not with generics.

* Casts with parameterized types gives warning.

* getClass() returns raw type for generic types.

* Can not make generic array, but ArrayList is possible
    ````java
        Pair<String>[] arr = new Pair<String>[10];    // Error
    ````
* Varargs are allowed since we just read from the array not store anything.
    * Use @SafeVarargs annotation after you make sure no one writes to this array, it is only read from.
