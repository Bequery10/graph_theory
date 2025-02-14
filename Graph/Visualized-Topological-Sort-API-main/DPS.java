import java.util.LinkedList;

import java.util.Stack;

public class DPS {
    private static int edgeTo[]; // Array to store the edgeTo information
    private static boolean visited[]; // Array to keep track of visited vertices
    private static Stack<Integer> stack; // Stack to push, first-order
    private static Stack<Integer> stack1; // Stack to push post-order

    // Method to get the shortest path between two vertices in a graph
    public static void search(Graph g,int start){
        start--;
        visited = new boolean[g.V()]; // Initialize visited array
        edgeTo = new int[g.V()]; // Initialize edgeTo array
       

        searchHelper(g,start);
        int nonVisited=getNonVisited();
        while(nonVisited!=-1){
            searchHelper(g,nonVisited);
        }
    }

    // Helper method for getShortestPath
    public static void searchHelper(Graph g,int v){

        visited[v] = true; // Set the visited true to not get in an infinite loop

        for(int w: g.adj(v)){
            if(!visited[w]){ // Check to see if the vertex is visited earlier
               
              
               edgeTo[w]=v;
               searchHelper(g,w); // Recursive call, building the path
               
            }
        }

     }

     public static Stack<Integer> search(DiGraph g,int start){
        start--;
        visited = new boolean[g.V()]; // Initialize visited array
        edgeTo = new int[g.V()]; // Initialize edgeTo array
        stack=new Stack<>();
        stack1=new Stack<>();

        searchHelper(g,start);
        int nonVisited=getNonVisited();
        while(nonVisited!=-1){
            searchHelper(g,nonVisited);
            nonVisited=getNonVisited();
        }
        return stack1;
    }

    public static void searchHelper(DiGraph g,int v){
        visited[v] = true; // Set the visited true to not get in an infinite loop
        
        stack.push(v);
        for(int w: g.adj(v)){
            if(!visited[w]){ // Check to see if the vertex is visited earlier
               
               edgeTo[w]=v;
               searchHelper(g,w); // Recursive call, building the path
               
            }
        }
        stack1.push(stack.pop()); // post-oder
     }

     private static int getNonVisited(){ // return non visited verticies

        for(int i=0;i<visited.length;i++){
            if(!visited[i])return i;
        }
        return -1;
     }

}