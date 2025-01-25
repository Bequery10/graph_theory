import java.util.Random;

class Main{                             
    public static void main(String args[]){                  boolean display=true; // if eddEdges function used, prints the adjacents
        int size=10; //size of the DiGraph
        DiGraph graph=new DiGraph(size); // DiGraph
      
        // adds edges randomly if required
        addEdges(graph,5,display,""); 
      
        //TopologicalSort.sort(graph,1);
        Kosaraju_Sharir.sort(graph);
    }


private static void addEdges(Graph graph, int edges,boolean display){
    Random random=new Random();
    int size= graph.V();
    for(int i=0;i<size;i++) {
		
        int iCAmount= random.nextInt(0,edges);
        
    for(int j=0;j<iCAmount;j++) {
        int num=random.nextInt(0,size);
        while(num==i || graph.isExist(i,num)) num=random.nextInt(0,size);
    graph.addEdge(i, num);
    }
    
    
    }
    if(display){
    for(int v=0;v<graph.V();v++) {
    System.out.printf("\n%d -> ",(v+1));
    for(int v1: graph.adj(v)) {
        System.out.printf(" %d ",(v1+1));
    }
    }
    
    System.out.println("\n");
    }
}

private static void addEdges(DiGraph graph, int edges,boolean display, String type){
    if(type.equals("DAG")){
    Random random=new Random();
    int size= graph.V();
    for(int i=0;i<size;i++) {
		
        int iCAmount= random.nextInt(0,edges);
        
    for(int j=0;j<iCAmount;j++) {
        int num=random.nextInt(i,size);
    graph.addEdge(i, num);
    }
    
    
    }
    if(display){
    for(int v=0;v<graph.V();v++) {
    System.out.printf("\n%d -> ",(v+1));
    for(int v1: graph.adj(v)) {
        System.out.printf(" %d ",(v1+1));
    }
    }
    
    System.out.println("\n");
    }
  }

  else if(type.equals("")){
    Random random=new Random();
    int size= graph.V();
    for(int i=0;i<size;i++) {
		
        int iCAmount= random.nextInt(0,edges);
        
    for(int j=0;j<iCAmount;j++) {
        int num=random.nextInt(0,size);
    graph.addEdge(i, num);
    }
    
    
    }
    if(display){
    for(int v=0;v<graph.V();v++) {
    System.out.printf("\n%d -> ",(v+1));
    for(int v1: graph.adj(v)) {
        System.out.printf(" %d ",(v1+1));
    }
    }
    
    System.out.println("\n");
    }

  }
}

}