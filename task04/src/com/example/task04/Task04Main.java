package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Map;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
        br.lines()
                .map(String::toLowerCase)
                .flatMap(x -> Stream.of(x.split("[^a-zа-яё0-9]")))
                .filter(x -> !x.isEmpty())
                .collect(Collectors.groupingBy(key -> key, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(x -> System.out.print(x + "\n"));






    }

}
