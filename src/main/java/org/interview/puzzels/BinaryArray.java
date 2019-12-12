package org.interview.puzzels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryArray {
    List<Integer> a;

    public BinaryArray(Integer[] values) {
        a = (List<Integer>) Arrays.asList(values);
    }

    private BinaryArray(int size) {
        a = IntStream.range(0, size).boxed().map(i -> 0).collect(Collectors.toList());
    }

    private BinaryArray() {
        a = new ArrayList<Integer>();
    }

    private int get(int index) {
        return a.get(index);
    }

    private void set(int index, int value) {
        a.set(index, value);
    }

    private int size() {
        return a.size();
    }

    BinaryArray add(BinaryArray rhs) {

        BinaryArray results = new BinaryArray(rhs.size() + 1);
        for (int i = a.size() - 1; i >= 0; i--) {
            int x = rhs.get(i) + get(i) + results.get(i + 1);
            if (x == 3) {
                results.set(i + 1, 1);
                results.set(i, 1);
            } else if (x == 2) {
                results.set(i + 1, 0);
                results.set(i, 1);
            } else if (x == 1) {
                results.set(i, 1);
            }
        }
        return results;
    }

    int convert() {
        int total = 0;
        int size = a.size();
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a.get(i) > 0) {
                total += Math.pow(2, (size-i-1));
            }
        }
        return total;
    }

    BinaryArray(int value, boolean convert) {
        a = new ArrayList<Integer>();

        int counter = 1;
        boolean cont = true;
        do {
            if(value < Math.pow(2, counter)) {
                counter -= 1;
                cont = false;
            }
            else {
                counter++;
            }
        } while(cont);

        int work = value;
        for(int i = counter; i >= 0; --i) {
            if(work > 0) {
                double next = Math.pow(2, i);
                if(next > work) {
                    a.add(0);
                }
                else {
                    work -= next;
                    a.add(1);
                }
            }
            else {
                a.add(0);
            }
        }
    }

    void print() {
        a.forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryArray c = new BinaryArray(20, true);
        c.print();

        Integer ar[] = {1, 1, 1, 1};
        Integer al[] = {0, 1, 0, 1};

        BinaryArray lhs = new BinaryArray(al);
        BinaryArray rhs = new BinaryArray(ar);
        BinaryArray sum = lhs.add(rhs);
        sum.print();

        System.out.println(sum.convert());

    }
}