package org.interview.dijkstra.algorithm;

import org.interview.dijkstra.model.Edge;
import org.interview.dijkstra.model.Vertex;
import org.interview.dijkstra.model.Graph;

import java.util.*;

public class Dijkstra {
    private final List<Vertex> nodes;
    private final List<Edge> edges;
    private Set<Vertex> settledNodes;
    private Set<Vertex> unSettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distances;

    public Dijkstra(Graph graph) {
        this.nodes = new ArrayList<>(graph.getVertexes());
        this.edges = new ArrayList<>(graph.getEdges());
    }

    public void run(Vertex source) {
        settledNodes = new HashSet<>();
        unSettledNodes = new HashSet<>();
        predecessors = new HashMap<>();
        distances = new HashMap<>();
        distances.put(source, 0);
        unSettledNodes.add(source);

        while(unSettledNodes.size() > 0) {
            Vertex node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Vertex node) {
        List<Vertex> adjacentNodes = getNeighbors(node);
        for (Vertex target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distances.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    private int getDistance(Vertex node, Vertex target) {
        for(Edge edge : edges) {
            if(edge.getSource().equals(node) &&
                    edge.getDesitnation().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Unexpected issue!");
    }

    private List<Vertex> getNeighbors(Vertex node) {
        List<Vertex> neighbors = new ArrayList<>();
        for(Edge edge : edges) {
            if(edge.getSource().equals(node) &&
                    settledNodes.contains(node)) {
                neighbors.add(edge.getDesitnation());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> vertexes) {
        Vertex minimum = null;
        for(Vertex vertex : vertexes) {
            if(minimum == null) {
                minimum = vertex;
            }
            else if(getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }
        return minimum;
    }

    private int getShortestDistance(Vertex destination) {
        Integer d = distances.get(destination);
        if(d == null) {
            return Integer.MAX_VALUE;
        }
        else {
            return d;
        }
    }

    public LinkedList<Vertex> getPath(Vertex target) {
        LinkedList<Vertex> path = new LinkedList<Vertex>();
        Vertex step = target;
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }
}
