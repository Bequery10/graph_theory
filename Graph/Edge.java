
import java.util.*;

class Edge implements Comparable<Edge> {

    private final int v, w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v)
            return w;
        else
            return v;

    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge edge) {

        if (this.weight > edge.weight)
            return 1;
        else if (this.weight < edge.weight)
            return -1;
        else
            return 0;

    }

}