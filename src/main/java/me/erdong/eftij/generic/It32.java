package me.erdong.eftij.generic;

import java.util.List;

public class It32 {
    public static void main(String[] args) {
        // dangerous(List.of("foo", "bar", "baz"));
        toArray(new Person(), new Person());


        // Stream.of("foo", "bar", "baz").collect()
    }

    // Mixing generics and varargs can violate type safety!

    // @SafeVarargs
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;
        // Heap pollution
        String s = stringLists[0].get(0); // ClassCastException
    }

    static Person[] toArray(Person... ps) {
        return ps;
    }

    private static final class Person {
    }
}
