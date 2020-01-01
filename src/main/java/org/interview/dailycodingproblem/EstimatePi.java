package org.interview.dailycodingproblem;

import java.util.Random;

/*
    The area of a circle is defined as πr^2. Estimate π to 3 decimal places
    using a Monte Carlo method
 */
public class EstimatePi {
    private int randomBetween(final int x, final int y) {
        return new Random().nextInt(y - x + 1) + x;
    }

    double runSimulation(int interval) {
        double pi = 0;
        double rangeMin = 0.0D;
        double rangeMax = 1.0D;

        int circlePoints = 0, squarePoints = 0;
        Random generator = new Random();
        for(int i = 0; i < (interval * interval); i++) {
            squarePoints++;
             double randX = rangeMin + (rangeMax - rangeMin) * generator.nextDouble();
             double randY = rangeMin + (rangeMax - rangeMin) * generator.nextDouble();
            if(Math.pow(randX, 2) + Math.pow(randY, 2) <= 1) {
                circlePoints++;
            }
        }
        pi = Double.valueOf(4 * circlePoints) / squarePoints;
        return pi;
    }

    public static void main(String[] args) {
        EstimatePi o = new EstimatePi();
        System.out.println(o.runSimulation(10));
        System.out.println(o.runSimulation(100));
        System.out.println(o.runSimulation(1000));
        System.out.println(o.runSimulation(5000));
    }
}
