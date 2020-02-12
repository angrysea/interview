package org.interview.leetcode;

import org.interview.mapsandgraphs.HashMapTest;

import java.util.TreeMap;
import java.util.Map;

public class MyCalendar {
    TreeMap<Integer, Integer> bookings = new TreeMap<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if(end<=start) {
            return false;
        }

        Integer earliestStart = bookings.floorKey(start);
        Integer latestStart = bookings.ceilingKey(start);

        if((earliestStart == null || bookings.get(earliestStart) <= start) &&
                (latestStart == null || latestStart >= end)) {
            bookings.put(start, end);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCalendar o = new MyCalendar();
        System.out.println(o.book(10,20));
        System.out.println(o.book(15,20));
        System.out.println(o.book(30,40));
        System.out.println(o.book(20,30));
    }
}
