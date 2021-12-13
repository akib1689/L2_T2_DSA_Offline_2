package com.company;

public class Edge {
    private Vertex src, des;
    private double weight;

    public Edge(Vertex src, Vertex des, double weight) {
        this.src = src;
        this.des = des;
        this.weight = weight;
    }

    public Vertex getSrc() {
        return src;
    }

    public Vertex getDes() {
        return des;
    }

    public double getWeight() {
        return weight;
    }
}
