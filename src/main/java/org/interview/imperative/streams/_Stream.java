package org.interview.imperative.streams;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.interview.imperative.streams._Stream.Person.*;

public class _Stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Alesha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );

        Optional.ofNullable(null).ifPresentOrElse(System.out::println,
                () -> System.out.println("Value is null."));

        people.stream().map(Person::getGender).forEach(System.out::println);
        Predicate<Person> isFemale = p -> Gender.FEMALE.equals(p.gender);
        people.stream().filter(isFemale).collect(Collectors.toList()).forEach(System.out::println);

    }

    static class Person {
        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

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

        enum Gender {MALE, FEMALE}
    }
}
