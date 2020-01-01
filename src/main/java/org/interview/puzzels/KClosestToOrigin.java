package org.interview.puzzels;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestToOrigin {

    static class Point {
        double x;
        double y;
        double distance;

        Point(int x, int y) {
            this.x = x;
            this.y =y;
            this.distance = Math.sqrt(Math.pow(Math.abs(x), 2) + Math.pow(Math.abs(y), 2));
        }
    }

    List<Point> getKClosest(List<Point> points, int k) {
        List<Point> theKClosest = new ArrayList<>();

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> { return Double.compare(b.distance, a.distance);});
        for(Point p : points) {
            pq.add(p);
            if(pq.size() > k) {
                pq.remove();
            }
        }

        for(int i = 0; i < k; i++) {
            theKClosest.add(pq.poll());
        }

        return theKClosest;
    }

    static public void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(-2, 4));
        points.add(new Point(3, 2));
        points.add(new Point(-1, 0));
        points.add(new Point(-2, 0));
        points.add(new Point(-2, -3));

        points.forEach(p -> System.out.printf("x: %f, y: %f, distance: %f.\n",
                p.x, p.y, p.distance));
        KClosestToOrigin o = new KClosestToOrigin();
        o.getKClosest(points, 2).forEach(p -> System.out.printf("x: %f, y: %f, distance: %f.\n",
                p.x, p.y, p.distance));
    }

}
