package com.meshale.PlayGround;

import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {

        int[] arr = {3,5,6,4,2,3,1,5};
        //process(arr,0, wrapperLambda((v, k)-> System.out.println( v / k)));
        process(arr,0, checkException( (v, k)-> System.out.println( v / k)) );

    }

    public static void process(int[] arr, int key, BiConsumer<Integer, Integer> consumer){
        for(int i : arr)
            consumer.accept(i,key);
    }

    /**
     * Handle arithmetic exception in the lambda expression by wrapping it with try catch
     * @param consumer
     * @return same parameter consumer but if any exception occured, it will be handled
     */
/*
    public static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
        return (v,k)->{
            try {
                consumer.accept(v, k);
            }catch(ArithmeticException e){
                System.out.println("Exception Handled in wrapper lambda");
            }
        };
    }
*/
/*
    public static <V,U> BiConsumer<V,U> wrapperLambda(BiConsumer<V,U> consumer){
        return (v,k)->{
            try{
                consumer.accept(v,k);
            }catch (Exception e){
                System.out.println("Exception handled in generic wrapper lambda");
            }
        };
    }
*/
    public static <V,U> BiConsumer<V,U> checkException(BiConsumer<V,U> consumer){
        return (v,k)->{
            try{
                consumer.accept(v,k);
            }catch (Exception e){
                System.out.println("Exception handled in generic wrapper lambda");
            }
        };
    }
}