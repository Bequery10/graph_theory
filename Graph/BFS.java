import java.util.LinkedList;
import java.util.Queue;

class BFS{
    private static boolean visited[];
    private static int edgeTo[];
    private static int distTo[];
    private static Queue<Integer> queue;


    public static void search(Graph g, int start, int end){
       start--;
       end--;
        visited=new boolean[g.V()];
        edgeTo=new int[g.V()];
        distTo=new int[g.V()];
        queue=new LinkedList<>();
       
 
        queue.offer(start);
        visited[start]=true;
        
       int level=0;;
        while(!queue.isEmpty()){
            int v=queue.poll();
            distTo[v]=level++;
            
            for(int w:g.adj(v)){
                if(!visited[w]){
                edgeTo[w]=v;
                queue.offer(w);
                visited[w]=true;
               }
            }
        }

    }

    // public static void printPath(){
    //     int[][]arr2D=new int[distTo.length][visited.length];

        

    //     for(int i=0;i<arr2D.length;i++){
    //         int start=arr2D[i].length/2 - distTo[.length/2;
    //         int end=start+distTo[i].length();
    //         for(int j=0;j<arr2D[i].length;j++){
                
    //             if(j>= start && j<=end)
    //             System.out.println(arr2D[j]);
    //             else
    //             System.out.print(" ");
    //         }
    //     }

    // }

}