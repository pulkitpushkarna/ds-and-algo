package com.ds.graph;

import java.util.LinkedList;

public class UnweightedGraph {

    LinkedList<Integer>[] adj;

    UnweightedGraph(int nodes) {
        this.adj = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int w, int v) {
        this.adj[w].add(v);
        this.adj[v].add(w);
    }
}
