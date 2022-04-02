package com.ds.graph;

public class Edge {
    private int src;
    private int nbr;
    private int wt;

    public Edge(int src, int nbr, int wt) {
        this.src = src;
        this.nbr = nbr;
        this.wt = wt;
    }

    public int getSrc() {
        return src;
    }

    public int getNbr() {
        return nbr;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", nbr=" + nbr +
                ", wt=" + wt +
                '}';
    }
}
