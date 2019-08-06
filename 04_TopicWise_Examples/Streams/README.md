# Streams

````java
    List<String> words = new ArrayList<>(Arrays.asList("Mustafa", "Ahmet", "Mert", "Halil", "Yusuf"));
    
    // Let's count number of words that have at least 5 characters
    long count = words.stream().filter( word -> word.length() >= 5).count();
    
    System.out.println("Number of words that have at least 5 characters: " + count );
    
    // Let's print each of them
    words.stream().filter( word -> word.length() >= 5).forEach( System.out::println );
````

## Stream Creation

````java
    /* Stream Creation */

    // Turn any collection into stream with stream() method
    List<String> words = new ArrayList<>(Arrays.asList("Mustafa", "Ahmet", "Mert", "Halil", "Yusuf"));
    Stream<String> wordStream = words.stream();

    // Turn any array into stream
    String[] names = {"Kemal", "Asaf"};
    Stream<String> nameString = Stream.of(names);

    // Stream.of is a varargs method
    Stream<Integer> ages = Stream.of(1,2,3,4,5,6,7,8,9,10);

    // We can make empty stream
    Stream<Double> rates = Stream.empty();
````

### Infinite Stream Creation

````java
    /* Infinite Streams*/

    // Generate by supplying a Supplier
    Stream<String> echos = Stream.generate( ()->"echo" );
    Stream<Double> randoms = Stream.generate( Math::random );

    // Produces sequences such as 0 1 2 3 4 by using Stream.iterate
    Stream<BigInteger> bigIntegers = Stream.iterate( BigInteger.ONE, number->number.add(BigInteger.ONE) );
    
````