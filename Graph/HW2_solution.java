
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.PriorityQueue;
// import java.util.List;

// public class HW2_solution {
// private static PriorityQueue<String > queue=new PriorityQueue<>();
// public static void main(String[] args) throws IOException {

// DiGraph graph= FileRead.readGraph("HW2_text.txt");

// System.out.println();

// int v=0;
// DPS.search(graph, v);

// while(!queue.isEmpty()){
// String path=queue.poll();
// path=path.substring(path.indexOf(' ')+1);
// System.out.println(path);
// }

// }

// class DiGraph {
// List<List<Integer>> adj;
// final private int V;

// public DiGraph(int size){
// this.V=size;

// adj=new ArrayList<>();
// for(int i=0;i<size;i++)
// adj.add(new ArrayList<>());

// }

// public int V(){
// return V;
// }

// public void addEdge(int v, int w){
// if(v==w || isExist(v,w)) return;

// adj.get(v).add(w);

// }

// public Iterable<Integer> adj(int v){
// return adj.get(v);
// }

// public boolean isExist(int v, int w){
// for(int w1:adj(v)){
// if(w1==w) return true;
// }
// return false;
// }
// }

// static class DPS {
// private static int edgeTo[]; // Array to store the edgeTo information
// private static boolean visited[]; // Array to keep track of visited vertices

// public static void search(DiGraph g,int start){

// visited = new boolean[g.V()]; // Initialize visited array
// edgeTo = new int[g.V()]; // Initialize edgeTo array

// String path="";
// searchHelper(g,start,path);
// }

// public static void searchHelper(DiGraph g,int v,String path){
// visited[v] = true; // Set the visited true to not get in an infinite loop
// boolean connects=false;
// path+=v+" ";

// for(int w: g.adj(v)){
// connects=true;
// if(!visited[w]){ // Check to see if the vertex is visited earlier
// edgeTo[w]=v;
// searchHelper(g,w,path); // Recursive call, building the path

// }
// }
// visited[v] = false;

// if(!connects && v!=g.V()-1){
// path=path.substring(0,path.length()-1);
// queue.offer(path.length()+" "+path);
// }

// }

// }

// }
