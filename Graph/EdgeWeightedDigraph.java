import java.util.*;

public class EdgeWeightedDigraph {
    private final int V;
    private final List<List<DirectedEdge>> adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int v = 0; v < V; v++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj.get(v).add(e);
    }

    public int V() {
        return V;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj.get(v);
    }
}