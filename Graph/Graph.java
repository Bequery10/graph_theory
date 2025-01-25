import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<List<Integer>> adj;
    final private int V;

    
    public Graph(int size){
        this.V=size;
        adj=new ArrayList<>();
        for(int i=0;i<size;i++)
        adj.add(new ArrayList<>());
        
    }

    public int V(){
        return V;
    }

    public void addEdge(int v, int w){
        if(v==w) return;

            adj.get(v).add(w);
            adj.get(w).add(v);
        
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
}
