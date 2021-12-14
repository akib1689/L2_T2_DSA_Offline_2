package com.company;

import java.util.ArrayList;

public class AdjacencyListGraph {
    private int n;
    private final ArrayList<Vertex> vertices;

    public AdjacencyListGraph(int n) {
        this.n = n;
        vertices = new ArrayList<>();
        for (int i=0;i<n;i++){
            Vertex v = new Vertex(i);
            vertices.add( v);
        }
    }


    public void addEdge(int u, int v, double weight){
        Vertex src = vertices.get(u);
        Vertex des = vertices.get(v);
        Edge e1 = new Edge(src, des, weight);
        src.addEdge(e1);
    }

    public void printGraph(){
        for (Vertex v: vertices){
            System.out.print(v.getNode() + "->");
            for (Edge e: v.getAdj()){
                System.out.print(e.getDes().getNode()+",");
            }
            System.out.println();
        }
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }
}
