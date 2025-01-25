// import java.io.IOException;
// import java.util.*;
// import java.util.PriorityQueue;

// public class HW3Solution {

// public static void main(String[] args) throws IOException {

// HW3Solution.EdgeWeightedDigraph G = FileRead.readGraph("Hw3.txt");

// int s = 0;
// HW3Solution hw3Solution = new HW3Solution();
// HW3Solution.SP sp = hw3Solution.new SP(G, s);

// System.out.println();
// System.out.println("The result");
// for (int v = 1; v < G.V() - 1; v++) {

// System.out.print(s + " ");
// for (HW3Solution.DirectedEdge e : sp.pathTo(v))
// System.out.print(e.to() + " ");
// System.out.print(sp.distTo(v));
// System.out.println();
// }

// }

// class SP {
// private double[] distTo;
// private HW3Solution.DirectedEdge[] edgeTo;
// private PriorityQueue<Integer> pq;
// private int s;

// public SP(HW3Solution.EdgeWeightedDigraph G, int s) {
// this.s = s;
// distTo = new double[G.V()];
// edgeTo = new HW3Solution.DirectedEdge[G.V()];

// for (int v = 0; v < G.V(); v++) {
// distTo[v] = Double.POSITIVE_INFINITY;
// }
// distTo[s] = 0.0;

// pq = new PriorityQueue<>(Comparator.comparingDouble(v -> distTo[v]));
// pq.offer(s);

// while (!pq.isEmpty()) {
// int v = pq.poll();
// for (HW3Solution.DirectedEdge e : G.adj(v)) {
// relax(e);
// }
// }
// }

// private void relax(HW3Solution.DirectedEdge e) {
// int v = e.from(), w = e.to();
// if (distTo[w] > distTo[v] + e.weight()) {
// distTo[w] = distTo[v] + e.weight();
// edgeTo[w] = e;
// pq.offer(w);
// }
// }

// public double distTo(int v) {
// return distTo[v];
// }

// public boolean hasPathTo(int v) {
// return distTo[v] < Double.POSITIVE_INFINITY;
// }

// public Iterable<HW3Solution.DirectedEdge> pathTo(int v) {
// if (!hasPathTo(v))
// return null;
// LinkedList<HW3Solution.DirectedEdge> path = new LinkedList<>();
// for (HW3Solution.DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
// {
// path.addFirst(e);
// }
// return path;
// }
// }

// class DirectedEdge {
// private final int v, w;
// private final double weight;

// public DirectedEdge(int v, int w, double weight) {
// this.v = v;
// this.w = w;
// this.weight = weight;
// }

// public int from() {
// return v;
// }

// public int to() {
// return w;
// }

// public double weight() {
// return weight;
// }
// }

// public class EdgeWeightedDigraph {
// private final int V;
// private final List<List<HW3Solution.DirectedEdge>> adj;

// public EdgeWeightedDigraph(int V) {
// this.V = V;
// adj = new ArrayList<>();
// for (int v = 0; v < V; v++)
// adj.add(new ArrayList<>());
// }

// public void addEdge(HW3Solution.DirectedEdge e) {
// int v = e.from();
// adj.get(v).add(e);
// }

// public int V() {
// return V;
// }

// public double getEdgeWeight(int v, int w) {
// for (HW3Solution.DirectedEdge e : adj(v)) {
// int w1 = e.to();

// if (w1 == w)
// return e.weight();

// }
// return 0;
// }

// public Iterable<DirectedEdge> adj(int v) {
// return adj.get(v);
// }
// }
// }
