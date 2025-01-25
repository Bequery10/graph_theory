//-----------------------------------------------------
// Title: Graph Class
// Author: Berkan Gökgöz
// ID: 14323143528
// Section: 1
// Assignment: 1
// Description: Graph Structure
//-----------------------------------------------------

public class currentDPS {
    private static int edgeTo[]; // Array to store the edgeTo information
    private static boolean visited[]; // Array to keep track of visited vertices
    private static String path; // String to store the desired path

    // Method to get the shortest path between two vertices in a graph
    public static String getShortestPath(Graph g,int start, int end){
        start--;
        end--;
        visited = new boolean[g.V()]; // Initialize visited array
        edgeTo = new int[g.V()]; // Initialize edgeTo array
        path=null;
       
        String path1 = ""+(start+1);
        int []edgeTo1 = new int[g.V()];
        getShortestPathHelper(g,start,end,path1, edgeTo1);
        return path == path1 || path == null ?  "Path not found" : path;
    }

    // Helper method for getShortestPath
    public static void getShortestPathHelper(Graph g,int v,int data,String path1,int[]edgeTo1){
        if(v==data) { // Check to see if the desired vertex is reached
        	
            if(path1.length()>=(""+(data+1)).length() &&
                path1.substring(path1.length() - (""+(data+1)).length()).equals((data+1)+"")  && 
                (path==null || path1.length()<path.length())
                ){   // Check to see if the new path is shorted then the earlier or is this the first path we come up with
                   path=path1; // Change the paths
                   copyArray(edgeTo1,edgeTo); // Change the edgeTos
                }
             return;
        }

        visited[v] = true; // Set the visited true to not get in an infinite loop

        for(int w: g.adj(v)){
            if(!visited[w]){ // Check to see if the vertex is visited earlier
               edgeTo1[w] = v; 
               getShortestPathHelper(g,w,data,( path1 +" "+(w+1) ),edgeTo1); // Recursive call, building the path
               edgeTo1[w] = -1;
            }
        }

        visited[v] = false; // Set the visited false so that it can be reached again during another loop
    }

    // Method to get the smallest path between two vertices in a graph
    public static String getSmallestCycle(Graph g,int start, int end){
        start--;
        end--;
        visited = new boolean[g.V()]; // Initialize visited array
        edgeTo = new int[g.V()]; // Initialize edgeTo array
        path=null;
       
        String path1 = ""+(start+1);
        int []edgeTo1 = new int[g.V()];
        getSmallestCycleHelper(g,start,start,end,path1, edgeTo1,false);
        return path == path1 || path == null ?   "Path not found" : path;
    }

    // Helper method for getSmallestPath
    public static void getSmallestCycleHelper(Graph g,int v,int start,int data,String path1,int[]edgeTo1, boolean included){
        if(v==data)included=true; // Check to see if desired node is included
     
        if(included && v==start) { // Check to see if the desired vertex is reached
            if (path==null  || path1.length()==path.length() && path1.compareTo(path)<0 )
                {
                 
                   path1=path1.substring(0, path1.length()-(" "+(start+1)).length() );
                   path=path1;// Change the paths
                   copyArray(edgeTo1,edgeTo);// Change the edgeTos
                   
                }
             return;
        }

        visited[v] = true; // Set the visited true to not get in an infinite loop

        for(int w: g.adj(v)){
            if(!visited[w] || ( w==start) ){ // Check to see if the vertex is visited earlier
            //if(!visited[w] || (included && w==start) ){ //---------------------------------------------Proper solution
               edgeTo1[w] = v;
               getSmallestCycleHelper(g,w,start,data,( path1 +" "+(w+1) ),edgeTo1,included); // Recursive call, building the path
               edgeTo1[w] = -1;
            }
        }

        visited[v] = false; // Set the visited false so that it can be reached again during another loop
    }

    // Method to copy one array to another
    private static void copyArray(int[]arr1,int[]arr2){
        for(int i=0;i<arr1.length;i++){
            arr2[i] = arr1[i];
        }
    }
}
