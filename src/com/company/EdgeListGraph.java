package com.company;

import java.util.ArrayList;

public class EdgeListGraph {
    private int v;
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;

    public EdgeListGraph(int v) {
        this.v = v;
        edges = new ArrayList<>();
        vertices = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            vertices.add(new Vertex(i));
        }
    }

    public void addEdge(int src,int des, double weight){
        Vertex source = vertices.get(src);
        Vertex destination = vertices.get(des);
        Edge edge = new Edge(source, destination, weight);
        edges.add(edge);
    }

    public Edge getEdge(int index){
        return edges.get(index);
    }

    public Vertex getVertex(int index){
        return vertices.get(index);
    }

    public int numVertices() {
        return v;
    }

    public int numEdges(){
        return edges.size();
    }
}
