import java.util.*;
import java.util.PriorityQueue;

public class SP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private PriorityQueue<Integer> pq;

    public SP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq = new PriorityQueue<>(Comparator.comparingDouble(v -> distTo[v]));
        pq.offer(s);

        while (!pq.isEmpty()) {
            int v = pq.poll();
            for (DirectedEdge e : G.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            pq.offer(w);
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        LinkedList<DirectedEdge> path = new LinkedList<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.addFirst(e);
        }
        return path;
    }
}