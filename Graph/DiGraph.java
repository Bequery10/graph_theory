import java.util.ArrayList;
import java.util.List;

public class DiGraph {
    List<List<Integer>> adj;
    final private int V;
    
    public DiGraph(int size){
        this.V=size;

        adj=new ArrayList<>();
        for(int i=0;i<size;i++)
        adj.add(new ArrayList<>());
        
    }

    public int V(){
        return V;
    }

    public void addEdge(int v, int w){
        if(v==w || isExist(v,w)) return;

            adj.get(v).add(w);
      
    }

    public Iterable<Integer> adj(int v){
        return adj.get(v);
    }

    public boolean isExist(int v, int w){
        for(int w1:adj(v)){
            if(w1==w) return true;
        }
        return false;
    }

    public DiGraph getReverseGraph(){
        DiGraph graph=new DiGraph(V);
        for(int v=0;v<V;v++){
            for(int w: adj(v)){
                graph.addEdge(w, v);
            }
        }
        return graph;
    }
}
