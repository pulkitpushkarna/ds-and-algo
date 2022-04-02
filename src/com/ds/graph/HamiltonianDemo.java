package com.ds.graph;

import java.util.HashSet;
import java.util.LinkedList;

public class HamiltonianDemo {

    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph(7);
        weightedGraph.addEdge(0, 1, 10);
        weightedGraph.addEdge(0, 3, 10);
        weightedGraph.addEdge(1, 2, 10);
        weightedGraph.addEdge(2, 3, 10);
        weightedGraph.addEdge(2, 5, 10);
        weightedGraph.addEdge(3, 4, 10);
        weightedGraph.addEdge(4, 6, 10);
        weightedGraph.addEdge(5, 6, 10);
        weightedGraph.addEdge(4, 5, 10);

        HashSet<Integer> visited = new HashSet<>();
        hamiltonianPath(weightedGraph.edges, 0, visited, "0", 0);
    }

    public static void hamiltonianPath(LinkedList<Edge>[] edges, int src, HashSet<Integer> visited, String psf, Integer oSrc) {
        if (visited.size() == edges.length - 1) {
            System.out.print(psf);
            boolean cyclicEdge = false;
            for (Edge edge : edges[src]) {
                if (edge.getNbr() == oSrc) {
                    cyclicEdge = true;
                }
            }
            if (cyclicEdge) {
                System.out.println("*");
            } else {
                System.out.println(".");
            }
        }
        visited.add(src);
        for (Edge edge : edges[src]) {
            if (!visited.contains(edge.getNbr())) {
                hamiltonianPath(edges, edge.getNbr(), visited, psf + edge.getNbr(), oSrc);
            }
        }
        visited.remove(src);
    }
}
