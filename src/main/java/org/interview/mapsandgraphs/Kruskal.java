package org.interview.mapsandgraphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {
    static class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    class SubSet {
        int parent, rank;
    }

    int verticies;
    List<Edge> edges = new ArrayList<>();

    Kruskal(int verticies) {
        this.verticies = verticies;
    }

    void addEdge(int source, int dest, int weight) {
        edges.add(new Edge(source, dest, weight));
    }

    List<Edge> findMST() {
        PriorityQueue<Edge> queue = new PriorityQueue<>(edges.size(), Comparator.comparingInt(o -> o.weight));
        edges.stream().forEach(queue::add);

        SubSet[] parents = new SubSet[verticies];
        for(int i = 0; i < verticies; i++) {
            parents[i] = new SubSet();
            parents[i].parent = i;
            parents[i].rank = 0;
        }

        List<Edge> mst = new ArrayList<>();
        int index = 0;
        while(index < verticies -1) {
            Edge edge = queue.remove();
            int x = find(parents, edge.source);
            int y = find(parents, edge.dest);

            if(x != y) {
                mst.add(edge);
                index++;
                union(parents, x, y);
            }
        }
        return mst;
    }

    int find(SubSet[]parents, int vertex) {
        if (parents[vertex].parent != vertex) {
            return find(parents, parents[vertex].parent);
        }
        return vertex;
    }

    void union(SubSet [] parents, int x, int y){
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
        int vertices = 6;
        Kruskal graph = new Kruskal(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
       graph.findMST().forEach(edge -> System.out.printf(
                "Edge - source: %d destination: %d weight: %d.\n",
                edge.source, edge.dest, edge.weight));
    }
}
