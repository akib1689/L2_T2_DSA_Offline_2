package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){


            String line = reader.readLine();
            String [] input = line.split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            Graph graph = new Graph(n);

            for (int i = 0; i < m; i++) {
                line = reader.readLine();
                input = line.split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                double w = Double.parseDouble(input[2]);

                graph.addEdge(u,v,w);
            }

            graph.printGraph();

            line = reader.readLine();
            input = line.split(" ");
            int src = Integer.parseInt(input[0]);
            int des = Integer.parseInt(input[1]);

            Dijkstra algo = new Dijkstra(graph);

            algo.findPath(src,des);

        }catch (IOException e){
            e.printStackTrace();
        }


        // for creating the file input.txt
        /*try(BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))){

        }catch (IOException e){
            e.printStackTrace();
        }*/
    }
}
