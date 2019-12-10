package org.interview.puzzels.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class TowerOfHanoi {
    List<Stack<Integer>> towers;

    void move(int a, int b) {
        towers.get(b).push(towers.get(a).pop());
    }

    void solve(List<Stack<Integer>> towers) {
        this.towers = towers;
        move(towers.get(0).size(), 0, 1, 2);
    }

    void move(int n, int source, int aux, int dest) {
        if(n == 1) {
            move(source, dest);
        }
        else {
            move(n-1, source, dest, aux);
            move(source, dest);
            move(n-1, aux, source, dest);
        }
    }


    public static void main(String[] args) {
        List<Stack<Integer>> towers = new ArrayList<>(3);
        IntStream.range(0, 3).forEach(i -> towers.add(i, new Stack<>()));
        Stack<Integer> stack = towers.get(0);

        for(int i = 0; i < 10; i++) {
            stack.push(i);
        }

        new TowerOfHanoi().solve(towers);
        System.out.println("Tower 1.");
        towers.get(0).forEach(System.out::println);
        System.out.println("Tower 2.");
        towers.get(1).forEach(System.out::println);
        System.out.println("Tower 3.");
        towers.get(2).forEach(System.out::println);
    }
}