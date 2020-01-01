package org.interview.dijkstra.model;

public class Edge {
    private final String id;
    private final Vertex source;
    private final Vertex desitnation;
    private final int weight;

    public Edge(String id, Vertex source, Vertex desitnation, int weight) {
        this.id = id;
        this.source = source;
        this.desitnation = desitnation;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDesitnation() {
        return desitnation;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "id='" + id + '\'' +
                ", source=" + source +
                ", desitnation=" + desitnation +
                ", weight=" + weight +
                '}';
    }
}
