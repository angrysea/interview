package org.interview.imperative;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", Person.Gender.MALE),
            new Person("Maria", Person.Gender.FEMALE),
            new Person("Alesha", Person.Gender.FEMALE),
            new Person("Alex", Person.Gender.MALE),
            new Person("Alice", Person.Gender.FEMALE)
        );

        Predicate<Person> isFemale = p -> Person.Gender.FEMALE.equals(p.gender);
        people.stream()
                .filter(isFemale)
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    static class  Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return String.format("Person{name='%s', gender=%s%n}", name, gender);
        }

        enum Gender { MALE, FEMALE}
    }
}
