package com.company;

import java.util.ArrayList;

public class Vertex {

    private final int node;
    private double cost;
    private boolean visited;
    private final ArrayList<Edge> adj;
    private Vertex parent;

    public Vertex(int node) {
        this.node = node;
        this.cost = Double.MAX_VALUE;
        this.visited = false;
        parent = null;
        adj = new ArrayList<>();
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNode() {
        return node;
    }

    public ArrayList<Edge> getAdj() {
        return adj;
    }


    public void addEdge(Edge edge){
        adj.add(edge);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;
        return this.node == vertex.node;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "node=" + node +
                ", cost=" + cost +
                '}';
    }
}
