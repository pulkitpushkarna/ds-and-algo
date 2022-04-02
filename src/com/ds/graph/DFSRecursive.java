package com.ds.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class DFSRecursive {

    public static void main(String[] args) {
        DFSRecursive dfsRecursive = new DFSRecursive();
        WeightedGraph weightedGraph = GraphUtils.createAndGetGraph();

        boolean[] visited = new boolean[weightedGraph.edges.length];
        System.out.println(dfsRecursive.hasPath(weightedGraph.edges, 0, 4, visited));
    }

    boolean hasPath(LinkedList<Edge>[] edges, int src, int des, boolean[] visited) {
        if (src == des) {
            return true;
        }
        visited[src] = true;
        System.out.println(Arrays.toString(visited));
        for (Edge edge : edges[src]) {
            if (visited[edge.getNbr()] == false) {
                boolean hasNbrPath = hasPath(edges, edge.getNbr(), des, visited);
                if (hasNbrPath) {
                    return hasNbrPath;
                }
            }
        }
        return false;

    }
}
