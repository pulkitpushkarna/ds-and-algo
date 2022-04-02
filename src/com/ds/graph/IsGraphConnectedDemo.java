package com.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IsGraphConnectedDemo {


    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph(7);
        weightedGraph.addEdge(0, 1, 10);
        weightedGraph.addEdge(1, 2, 10);
        weightedGraph.addEdge(2, 3, 10);
        weightedGraph.addEdge(3, 4, 10);
        weightedGraph.addEdge(4, 5, 10);
        weightedGraph.addEdge(5, 6, 10);
        boolean[] visited = new boolean[7];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        Arrays.stream(weightedGraph.edges).forEach(edges -> edges.forEach(edge -> {
                    if (!visited[edge.getSrc()]) {
                        ArrayList<Integer> component = new ArrayList<>();
                        getComponent(weightedGraph.edges, edge.getSrc(), visited, component);
                        components.add(component);
                    }
                }
        ));
        System.out.println("Graph is connected :: " + (components.size() == 1));

    }

    public static void getComponent(LinkedList<Edge>[] edges, int src, boolean[] visited, List<Integer> component) {
        visited[src] = true;
        component.add(src);
        for (Edge edge : edges[src]) {
            if (!visited[edge.getNbr()]) {
                getComponent(edges, edge.getNbr(), visited, component);
            }
        }
    }


}
