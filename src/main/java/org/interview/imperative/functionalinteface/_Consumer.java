package org.interview.imperative.functionalinteface;

import java.util.function.Consumer;

public class _Consumer {

    static Consumer<Customer> callme = c -> System.out.println(String.format("Hello it's %s call me at %s", c.name, c.phone));
    public static void main(String[] args) {
        Customer anthony = new Customer("Anthony", "555-123-4567");
        callme.accept(anthony);
    }

    static class Customer {
        private final String name;
        private final String phone;

        Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}
