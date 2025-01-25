import java.util.*;
import java.util.PriorityQueue;

public class ShortestPath {

    double[] distTo;
    DirectedEdge[] edgeTo;
    PriorityQueue<Integer> queue;
    private double sp;
    private String path;

    public void dijesktra(EdgeWeightedDigraph g, int s) {
        distTo = new double[g.V()];
        edgeTo = new DirectedEdge[g.V()];
        queue = new PriorityQueue<>(Comparator.comparingDouble(v -> distTo[v]));

        for (int v = 0; v < g.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        queue.offer(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (DirectedEdge e : g.adj(v))
                relaxEdges(e);
        }

    }

    private void relaxEdges(DirectedEdge e) {
        int v = e.from();
        int w = e.to();

        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;

            queue.offer(w);
        }
    }

    public double sp(int s) {

        if (sp != 0.0)
            return sp;

        DirectedEdge e = edgeTo[s];
        while (e != null) {
            sp += e.weight();
            e = edgeTo[e.from()];
        }

        return sp;

    }

    public String hasPathTo(int s) {

        if (path != "")
            return path;

        DirectedEdge e = edgeTo[s];
        while (e != null) {
            path += e.to() + " ";
            e = edgeTo[e.from()];
        }
        path += e.from();
        return path;
    }

}
