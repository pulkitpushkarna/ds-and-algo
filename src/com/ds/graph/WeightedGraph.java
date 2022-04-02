package com.ds.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class WeightedGraph {

    LinkedList<Edge>[] edges;

    WeightedGraph(int nodes) {
        this.edges = new LinkedList[nodes];
        for (int i = 0; i < this.edges.length; i++){
            this.edges[i]= new LinkedList<>();
        }
    }

    void addEdge(int src, int nbr, int weight) {
        this.edges[src].add(new Edge(src, nbr, weight));
        this.edges[nbr].add(new Edge(nbr, src, weight));
    }


    @Override
    public String toString() {
        return "WeightedGraph{" +
                "adj=" + Arrays.toString(edges) +
                '}';
    }
}


