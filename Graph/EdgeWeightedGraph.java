
import java.util.*;

public class EdgeWeightedGraph {

    private final int V;
    private List<List<Edge>> adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj.get(v).add(e);
        adj.get(w).add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj.get(v);
    }

    public double getEdgeWeight(int v, int w) {
        for (Edge e : adj(v)) {
            int v1 = e.either();
            int w1 = e.other(v1);

            if ((v1 == v && w1 == w) || (v1 == w && w1 == v)) {
                return e.getWeight();
            }
        }
        return 0;
    }

    public boolean isEdgeExist(int v, int w) {

        for (Edge e : adj(v))
            if (e.other(v) == w)
                return true;

        return false;
    }

    public int V() {
        return V;
    }
}
