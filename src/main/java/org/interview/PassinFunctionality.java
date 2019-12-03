package org.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PassinFunctionality {
    static class User {
        private String firstName;
        private String lastName;
        private boolean isActive;
        private double income;
        private double tax;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public double getIncome() {
            return income;
        }

        public void setIncome(double income) {
            this.income = income;
        }

        public double getTax() {
            return tax;
        }

        public void setTax(double tax) {
            this.tax = tax;
        }
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        executor.shutdown();
    }
}
