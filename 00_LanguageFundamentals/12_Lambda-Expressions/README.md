# Lambda Expressions

 ````java
class LengthComparator implements Comparator<String> 
{
   public int compare(String first, String second) 
   {
      return first.length() - second.length();
   }
}
````
 
 We pass code that checks whether one string is shorter than another.

```java
first.length() - second.length()
```

```java
(String first, String second)
   -> first.length() - second.length()
```

* What are first and second? They are both strings. Java is a strongly typed language, and we must specify that as well:

    * You have just seen your first lambda expression.

* If the code carries out a computation that doesn’t fit in a single expression, write it exactly like you would have written a method: enclosed in {} and with explicit return statements.
```java
(String first, String second) ->
   {
      if (first.length() < second.length()) return -1;
      else if (first.length() > second.length()) return 1;
      else return 0;
   }
```

* If a lambda expression has no parameters, you still supply empty parentheses, just as with a parameterless method:
```java
() -> { for (int i = 100; i >= 0; i--) System.out.println(i); }
```

* If the parameter types of a lambda expression can be inferred, you can omit them.
```java
Comparator<String> comp
   = (first, second) // same as (String first, String second)
      -> first.length() - second.length();
```

* If a method has a single parameter with inferred type, you can even omit the parentheses

```java
ActionListener listener = event ->
   System.out.println("The time is " 
      + Instant.ofEpochMilli(event.getWhen()));
      // instead of (event) -> . . . or (ActionEvent event) -> . . .
```

* You never specify the result type of a lambda expression. It is always inferred from context. 
    * The expression can be used in a context where a result of type int is expected.
    ```
    (String first, String second) -> first.length() - second.length()
    ```

* It is illegal for a lambda expression to return a value in some branches but not in others. For example, 
```java
(int x) -> { if (x >= 0) return 1; } // invalid
```

## Notes

* Value of the `this` reference inside any lambda expression is the same as outside of the lambda expression.
    * `this` reference is unchanged by the lambda expresion.
    