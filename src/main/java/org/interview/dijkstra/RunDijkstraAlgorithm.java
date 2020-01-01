package org.interview.dijkstra;

import org.interview.dijkstra.algorithm.Dijkstra;
import org.interview.dijkstra.model.Edge;
import org.interview.dijkstra.model.Graph;
import org.interview.dijkstra.model.Vertex;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RunDijkstraAlgorithm {
    List<Vertex> nodes = new ArrayList<Vertex>();
    List<Edge> edges = new ArrayList<>();

    RunDijkstraAlgorithm() {
        for (int i = 0; i < 11; i++) {
            nodes.add(new Vertex("Node_" + i, "Node_" + i));
        }
    }

    private void addEdge(String laneId, int sourceLocNo, int destLocNo, int duration) {
        Edge edge = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(edge);
    }

    LinkedList<Vertex> run() {
        Graph graph = new Graph(nodes, edges);
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.run(nodes.get(0));
        return dijkstra.getPath(nodes.get(10));
    }

    static public void main(String[] args) {
        List<Edge> edges = new ArrayList<Edge>();

        RunDijkstraAlgorithm o = new RunDijkstraAlgorithm();
        o.addEdge("Edge_0", 0, 1, 85);
        o.addEdge("Edge_1", 0, 2, 217);
        o.addEdge("Edge_2", 0, 4, 173);
        o.addEdge("Edge_3", 2, 6, 186);
        o.addEdge("Edge_4", 2, 7, 103);
        o.addEdge("Edge_5", 3, 7, 183);
        o.addEdge("Edge_6", 5, 8, 250);
        o.addEdge("Edge_7", 8, 9, 84);
        o.addEdge("Edge_8", 7, 9, 167);
        o.addEdge("Edge_9", 4, 9, 502);
        o.addEdge("Edge_10", 9, 10, 40);
        o.addEdge("Edge_11", 1, 10, 600);

        LinkedList<Vertex> path = o.run();
        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
    }
}
