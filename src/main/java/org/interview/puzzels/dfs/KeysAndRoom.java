package org.interview.puzzels.dfs;

import java.util.*;

public class KeysAndRoom {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final int n = rooms.size();
        Set<Integer> unlocked = new HashSet<>();
        visitRoom(0, rooms, unlocked);
        return unlocked.size() == rooms.size();
    }

    void visitRoom(int i, List<List<Integer>> rooms, Set<Integer> unlocked) {
        unlocked.add(i);
        List<Integer> room = rooms.get(i);

        for(Integer key : room) {
            if (!unlocked.contains(key)) {
                visitRoom(key, rooms, unlocked);
            }
        }
    }


    static public void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        System.out.printf("Can visit all rooms %b.\n", new KeysAndRoom().canVisitAllRooms(rooms));
    }
}
