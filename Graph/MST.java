import java.io.IOException;
import java.util.*;
import java.util.PriorityQueue;

public class MST {
    static EdgeWeightedGraph graph;
    static PriorityQueue<Edge> pQueue;
    static Queue<Edge> mst;
    static boolean visited[];

    public MST(int start, EdgeWeightedGraph g) throws IOException {

        pQueue = new PriorityQueue<>();
        mst = new LinkedList<>();
        graph = g;

        visited = new boolean[graph.V()];

        visit(start);

        while (!pQueue.isEmpty() && mst.size() < graph.V() - 1) {
            Edge e = pQueue.poll();
            int v = e.either();
            int w = e.other(v);
            if (visited[v] && visited[w])
                continue;

            mst.offer(e);
            if (!visited[v])
                visit(v);
            if (!visited[w])
                visit(w);
        }

    }

    private static void visit(int v) {

        for (Edge e : graph.adj(v)) {
            if (!visited[e.other(v)])
                pQueue.offer(e);
        }
        visited[v] = true;
    }

    public static Iterable<Edge> mst() {
        return mst;
    }

}
