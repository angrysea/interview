package org.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Graph {

    static class Vertex {
        enum Color {WHITE, GREY, BLACK}

        private Color color = Color.WHITE;
        private int distance = 0;
        private long discover;
        private long finish;
        private Vertex predecessor;
        private int value;
        private List<Vertex> adjacent;

        Vertex(final int value) {
            this.value = value;
            adjacent = new ArrayList<>();
        }

        Vertex get(final int index) {
            return adjacent.get(index);
        }

        Stream<Vertex> stream() {
            return adjacent.stream();
        }

        List<Vertex> getAdjacent() {
            return adjacent;
        }

        void add(Vertex v) {
            adjacent.add(v);
        }

        Color getColor() {
            return color;
        }

        void setColor(final Color color) {
            this.color = color;
        }

        int getDistance() {
            return distance;
        }

        void setDistance(final int distance) {
            this.distance = distance;
        }

        void setDiscover(long discover) {
            this.discover = discover;
        }

        long getFinish() {
            return finish;
        }

        void setFinish(long finish) {
            this.finish = finish;
        }

        Vertex getPredecessor() {
            return predecessor;
        }

        void setPredecessor(Vertex predecessor) {
            this.predecessor = predecessor;
        }

        int getValue() {
            return value;
        }

        private void init() {
            setColor(Vertex.Color.WHITE);
            setDistance(Integer.MAX_VALUE);
            setDistance(0);
            setPredecessor(null);
        }


    }

    private final List<Vertex> vertices;
    private int time;

    private Graph(final int size) {
        this.vertices = IntStream.range(0, size)
                .boxed()
                .map(i -> new Vertex(i))
                .collect(Collectors.toList());
    }

    public void addEdge(final int x, final int y) {
        vertices.get(x).add(vertices.get(y));
    }

    private boolean hasEdge(final int x, final int y) {
        try {
            return vertices.get(x).stream().anyMatch(v -> v.getValue() == y);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private void clearEdge(int x, int y) {
        try {
            Vertex current = vertices.get(x);
            for (Vertex adjacent : current.getAdjacent()) {
                if (adjacent.getValue() == y) {
                    current.getAdjacent().remove(adjacent);
                    return;
                }
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    private void depthFirstSearchRecursive() {
        vertices.forEach(v -> {
            v.setColor(Vertex.Color.WHITE);
            v.setDiscover(0);
            v.setFinish(0);
            v.setPredecessor(null);
        });

        time = 0;
        vertices.forEach(this::depthFirstSearchVisit);
    }

    private void depthFirstSearchVisit(Vertex vertex) {
        time += 1;
        vertex.setDiscover(time);
        vertex.setColor(Vertex.Color.GREY);
        vertex.stream()
                .filter(v -> v.getColor() == Vertex.Color.WHITE)
                .forEach(v -> {
                    v.setPredecessor(vertex);
                    depthFirstSearchVisit(v);
                });
        vertex.setColor(Vertex.Color.BLACK);
        time += 1;
        vertex.setFinish(time);
    }

    private void depthFirstSearch(final int index) {

        vertices.forEach(Vertex::init);

        Stack<Vertex> stack = new Stack<>();
        stack.push(vertices.get(index));

        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            if( current.getColor() == Vertex.Color.WHITE) {
                current.setColor(Vertex.Color.GREY);
            }
            current.stream()
                    .filter(v -> v.getColor() == Vertex.Color.WHITE)
                    .peek(v -> {
                        v.setColor(Vertex.Color.GREY);
                        v.setDistance(current.getDistance() + 1);
                        v.setPredecessor(current);
                    })
                    .forEach(stack::push);
            current.setColor(Vertex.Color.BLACK);
        }
    }

    private void breathFirstSearch(final int index) {
        vertices.forEach(v -> {
            v.setColor(Vertex.Color.WHITE);
            v.setDiscover(0);
            v.setFinish(0);
            v.setPredecessor(null);
        });

        time = 0;

        Queue<Vertex> queue = new LinkedList<>();
        Vertex start = vertices.get(index);
        start.setColor(Vertex.Color.GREY);
        start.setDistance(0);
        start.setPredecessor(null);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            current.stream()
                    .filter(v -> v.getColor() == Vertex.Color.WHITE)
                    .forEach(v -> {
                        v.setColor(Vertex.Color.GREY);
                        v.setDistance(current.getDistance() + 1);
                        v.setPredecessor(current);
                        queue.add(v);
                    });
            current.setColor(Vertex.Color.BLACK);
        }
    }

    private void print() {
        vertices.forEach(v -> {
            System.out.println("Index: " + v.getValue());
            System.out.println(" color: " + v.getColor());
            System.out.println(" distance: " + v.getDistance());
            if (v.getPredecessor() != null) {
                System.out.println(" predecessor: " + v.getPredecessor().getValue());
            }
            System.out.println();
        });
    }

    int[][] getMatrix() {
        int size = vertices.size();
        int[][] matrix = new int[size][size];
        vertices.forEach(vertex -> {

        });

        return matrix;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        if (g.hasEdge(2, 3))
            System.out.println("There is an edge between 3 and 4");
        else
            System.out.println("There is no edge between 3 and 4");

        if (g.hasEdge(1, 3))
            System.out.println("There is an edge between 2 and 4");
        else
            System.out.println("There is no edge between 2 and 4");

        g.breathFirstSearch(2);
        g.depthFirstSearch(0);
        g.print();

        g.clearEdge(2,3);
        if (g.hasEdge(2, 3))
            System.out.println("There is an edge between 3 and 4");
        else
            System.out.println("There is no edge between 3 and 4");
    }
}
