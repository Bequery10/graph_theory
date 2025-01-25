import java.util.Stack;

public class Kosaraju_Sharir {
  
    public static void sort(DiGraph g){
        DiGraph g2=g.getReverseGraph();

        Stack <Integer>stack=DPS.search(g2, 1);
        
        DPS.kosarajuSearch(g, stack);
    }
}
