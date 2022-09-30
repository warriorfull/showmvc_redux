package com.todd.ex.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
        Stream<String> nameStream = Stream.of("Tom", "Bob", "Tim");
        System.out.println(nameStream.count());
        IntStream integerStream = IntStream.range(1, 5);
        System.out.println("int stream count is " + integerStream.count());
        integerStream = IntStream.range(1, 6);
        integerStream.forEach(System.out::println);
        integerStream = IntStream.of(1, 5, 8);
        String[] names = {"Tom", "Bob", "Tim"};
        Stream<String> namesStream2 = Stream.of(names);
        System.out.println("names cnt : "+namesStream2.count());
        
        List<String> myList = new ArrayList<String>();
        myList.add("Tom");
        myList.add("Bob");
        myList.add("Tim");
        Stream<String> streamFromList = myList.stream();
        System.out.println("myList cnt: "+streamFromList.count());
        
        Stream<String> stEmpty = Stream.empty();
        System.out.println("stEmpty : "+stEmpty.count());
        
        Stream.Builder<String> stbuilder = Stream.builder();
        stbuilder.accept("Tom");
        stbuilder.accept("Jane");
        stbuilder.accept("Monique");
        Stream<String> myStream = stbuilder.build();
        System.out.println("myStream : "+myStream.count());
        

    }
}
