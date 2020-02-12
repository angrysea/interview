package org.interview.imperative.functionalinteface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.printf("Phone valid %b", isPhoneNumberValid.test("973-363-1234"));
    }
    static Predicate<String> isPhoneNumberValid = p -> p.startsWith("973") && p.length() == 12;
}
