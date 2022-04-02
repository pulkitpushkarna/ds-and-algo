package com.ds.graph;

public class GraphUtils {

    public static WeightedGraph createAndGetGraph() {
        WeightedGraph weightedGraph = new WeightedGraph(7);
        weightedGraph.addEdge(0, 3, 40);
        weightedGraph.addEdge(0, 1, 10);
        weightedGraph.addEdge(1, 2, 10);
        weightedGraph.addEdge(2, 3, 10);
        weightedGraph.addEdge(3, 4, 2);
        weightedGraph.addEdge(4, 5, 3);
        weightedGraph.addEdge(5, 6, 3);
        weightedGraph.addEdge(4, 6, 8);
        return weightedGraph;
    }
}
