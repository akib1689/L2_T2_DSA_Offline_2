package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public void findPath(int src, int des){
        ArrayList<Vertex> vertices = new ArrayList<>();

        Comparator<Vertex> costComp = Comparator.comparingDouble(Vertex::getCost);

        PriorityQueue<Vertex> pq = new PriorityQueue<>(costComp);

        Vertex source = graph.getVertices().get(src);
        Vertex destination = graph.getVertices().get(des);



        pq.addAll(graph.getVertices());
        source.setCost(0);


        while (!pq.isEmpty()){// v
            Vertex current = pq.poll();
            if (current.equals(destination)){
                break;
            }

            for (Edge edge: current.getAdj()){ // E
                double cost = current.getCost() + edge.getWeight();

                Vertex edgeDest = edge.getDes();
                if (!edgeDest.isVisited()){
                    pq.remove(edgeDest); // log v
                    if (cost < edgeDest.getCost()){
                        edgeDest.setCost(cost);
                        edgeDest.setParent(current);
                    }
                    pq.add(edge.getDes()); //log v
                }
            }
            current.setVisited(true);
        }


        if (destination.getParent() != null){
            System.out.println("cost to reach destination: " + destination.getCost());
            Vertex current = destination;
            while (current.getParent() != null){
                vertices.add(current);
                current = current.getParent();
            }
            vertices.add(current);
        }
        for (int i= vertices.size()-1; i>=0; i--){
            if (i != 0){
                System.out.print(vertices.get(i).getNode() + "->");
            }else {
                System.out.print(vertices.get(i).getNode());
            }
        }

    }
}
