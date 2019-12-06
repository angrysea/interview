package org.interview;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class KeysAndRoom {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        Stack<Integer> stack = new Stack<>();

        while(!stack.empty()) {
            List<Integer> keys = rooms.get(stack.pop());
            for(int key : keys) {
                if(!visited.contains(key)) {
                    visited.add(key);
                    stack.add(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}
