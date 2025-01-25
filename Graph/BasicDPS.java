
public class BasicDPS {
    private static int edgeTo[]; // Array to store the edgeTo information
    private static boolean visited[]; // Array to keep track of visited vertices
   
    // Method to get the shortest path between two vertices in a graph
    public static void search(Graph g,int start){
        start--;
        visited = new boolean[g.V()]; // Initialize visited array
        edgeTo = new int[g.V()]; // Initialize edgeTo array
       
        getShortestPathHelper(g,start);
    }

    // Helper method for getShortestPath
    public static void getShortestPathHelper(Graph g,int v){

        visited[v] = true; // Set the visited true to not get in an infinite loop

        for(int w: g.adj(v)){
            if(!visited[w]){ // Check to see if the vertex is visited earlier
               
               edgeTo[w]=v;
               getShortestPathHelper(g,w); // Recursive call, building the path
            }
        }

     }

     public static void search(DiGraph g,int start){
        start--;
        visited = new boolean[g.V()]; // Initialize visited array
        edgeTo = new int[g.V()]; // Initialize edgeTo array
       
        getShortestPathHelper(g,start);
    }

    public static void getShortestPathHelper(DiGraph g,int v){

        visited[v] = true; // Set the visited true to not get in an infinite loop

        for(int w: g.adj(v)){
            if(!visited[w]){ // Check to see if the vertex is visited earlier
               
               edgeTo[w]=v;
               getShortestPathHelper(g,w); // Recursive call, building the path
            }
        }

     }

}