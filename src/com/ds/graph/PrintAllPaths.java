package com.ds.graph;

import java.util.LinkedList;

public class PrintAllPaths {

    public static void main(String[] args) {
        PrintAllPaths printAllPaths = new PrintAllPaths();
        WeightedGraph weightedGraph = GraphUtils.createAndGetGraph();

        boolean[] visited = new boolean[weightedGraph.edges.length];
        printAllPaths.printPaths(weightedGraph.edges, 0, 6, visited, "0");
    }

    void printPaths(LinkedList<Edge>[] edges, int src, int des, boolean[] visited, String psf) {
        if (src == des) {
            System.out.println(psf);
            return;
        }
        visited[src] = true;
        for (Edge edge : edges[src]) {
            if (visited[edge.getNbr()] == false) {
                printPaths(edges, edge.getNbr(), des, visited, psf + edge.getNbr());
            }
        }
        visited[src] = false;
    }
}
