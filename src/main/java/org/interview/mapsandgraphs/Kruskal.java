package org.interview.mapsandgraphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class SubSet {
        int parent;
        int rank;
    }

    List<Edge> edges = new ArrayList<>();

    Kruskal() {
    }

    void addEdge(int source, int dest, int weight) {
        edges.add(new Edge(source, dest, weight));
    }

    List<Edge> findMST() {

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(edges.size(),
                Comparator.comparingInt(o -> o.weight));
        minHeap.addAll(edges);
        int verticies = minHeap.size();

        SubSet[] parents = new SubSet[verticies];
        for(int i = 0; i < verticies; i++) {
            parents[i] = new SubSet();
            parents[i].parent = i;
            parents[i].rank = 0;
        }

        List<Edge> mst = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            Edge edge = minHeap.remove();
            int x = find(parents, edge.source);
            int y = find(parents, edge.destination);

            if(x != y) {
                mst.add(edge);
                union(parents, x, y);
            }
        }
        return mst;
    }

    int find(SubSet[] parents, int vertex) {
        while (parents[vertex].parent != vertex) {
            vertex = parents[vertex].parent;
        }
        return vertex;
    }

    void union(SubSet[] parents, int x, int y){
        int xroot = find(parents, x);
        int yroot = find(parents, y);
        if(parents[xroot].rank < parents[yroot].rank) {
            parents[xroot].parent = yroot;
        } else if(parents[xroot].rank > parents[yroot].rank) {
            parents[yroot].parent = xroot;

        }
        else {
            parents[yroot].parent = xroot;
            parents[xroot].rank++;
        }
    }

    public static void main(String[] args) {
         Kruskal graph = new Kruskal();
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.findMST().forEach(edge -> System.out.printf(
                "Edge - source: %d destination: %d weight: %d.\n",
                edge.source, edge.destination, edge.weight));
    }
}
