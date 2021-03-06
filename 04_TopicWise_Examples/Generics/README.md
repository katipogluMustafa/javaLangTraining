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
    
## INHERITANCE RULES FOR GENERIC TYPES

![](img/1.jpg)

* Subtype relationships among generic list types
    ![](img/2.jpg)


## WILDCARD TYPES

* For those situations that you want to have inheritance relationships, you can use wildcard types.

