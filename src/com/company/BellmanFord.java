package com.company;

import java.util.ArrayList;

public class BellmanFord {
    private EdgeListGraph graph;

    public BellmanFord(EdgeListGraph graph) {
        this.graph = graph;
    }

    /*
    * runs the algorithm and find if the shortest path to all the nodes from the src vertex
    * fails if there is any negative weight cycle
    * reports the negative weight cycle if there is any
    * running time of the algorithm O(V*E)
    */
    public void startAlgo(int src, int des){
        //set the cost of the source vertex
        Vertex source = graph.getVertex(src);
        source.setCost(0);

        //relax the edges for v-1 times
        for (int i = 1; i < graph.numVertices(); i++) { // V
            for (int j = 0; j < graph.numEdges(); j++) { // E
                Vertex u = graph.getEdge(j).getSrc();
                Vertex v = graph.getEdge(j).getDes();
                double weight = graph.getEdge(j).getWeight();
                if (u.getCost() != Double.MAX_VALUE && u.getCost() + weight < v.getCost()){
                    v.setCost(u.getCost() + weight);
                    v.setParent(u);
                }
            }
        }

        //if there is negative weight cycle
        for (int i = 0; i < graph.numEdges(); i++) { // E
            Vertex u = graph.getEdge(i).getSrc();
            Vertex v = graph.getEdge(i).getDes();
            double weight = graph.getEdge(i).getWeight();
            if (u.getCost() != Double.MAX_VALUE && u.getCost() + weight < v.getCost()){
                System.out.println("The graph contains a negative cycle");
                return;
            }
        }

        System.out.println("The graph doesn't contain a negative cycle");
        Vertex destination = graph.getVertex(des);
        ArrayList<Vertex> path = new ArrayList<>();
        if (destination.getParent() != null){
            System.out.println("cost to reach destination: " + destination.getCost());
            Vertex current = destination;
            while (current.getParent() != null){
                path.add(current);
                current = current.getParent();
            }
            path.add(current);
        }

        for (int i= path.size()-1; i>=0; i--){
            if (i != 0){
                System.out.print(path.get(i).getNode() + "->");
            }else {
                System.out.print(path.get(i).getNode());
            }
        }
    }
}
