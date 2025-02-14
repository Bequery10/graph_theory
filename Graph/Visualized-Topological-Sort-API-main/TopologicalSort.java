import java.util.Hashtable;
import java.util.Stack;
import java.awt.Point;

public class TopologicalSort {
    private static Stack<Integer>stack;
    private static Hashtable<Integer,Point> table;

    public static void sort(DiGraph g,int start){
        stack=DPS.search(g,start);
        table=new Hashtable<>();

        char[][]arr=new char[stack.size()*2][stack.size()*2];
        
        int i=stack.size()*2-1, j=0;

       while(stack.isEmpty()==false){
        int v=stack.pop();
        
        table.put(v, new Point(i,j) );
        
        arr[i][j]=(char)(v+1);
        i-=2;
        j+=2;
       }

       //boolean[]visited=new boolean[g.V()];
       int count=0;
       for(int v: table.keySet()){
         Point p1=table.get(v);
         
         for(int w: g.adj(v)){ 
            
           

            count++;
            Point p2=table.get(w);

            Point smallerP=new Point(p1.x,p1.y);
            if(p2.x<p1.x) smallerP=new Point(p2.x,p2.y);

           if(Math.abs(p1.x-p2.x)==2 ){
            arr[smallerP.x+1][smallerP.y-1]=(char)-3;
           }

           else{
            int y=p1.y;
            if(y==smallerP.y) y = p2.y;

            int x=p1.x;
            if(x==smallerP.x) x = p2.x;
            
            while( ( Math.abs(smallerP.y-y)>0 || Math.abs(smallerP.x-x)>0 )){
                
                if(count%2==0 && Math.abs(smallerP.y-y)>0){
                    smallerP.y--;
                   
                    if(smallerP.y >= 0 &&( arr[smallerP.x][smallerP.y]==0 || arr[smallerP.x][smallerP.y]==65535 || arr[smallerP.x][smallerP.y]==65534 ) && arr[smallerP.x][smallerP.y]!=65533){
                    if(Math.abs(smallerP.y-y)>0){
                        if(arr[smallerP.x][smallerP.y]!=65535)
                    arr[smallerP.x][smallerP.y]=(char)-2;
                    }
                    else
                    arr[smallerP.x][smallerP.y]=(char)-3;
                    }
                }
                else if ( Math.abs(smallerP.x-x)>0){
                    smallerP.x++;
                    
                    if(smallerP.x < g.V()*2 &&( arr[smallerP.x][smallerP.y]==0 || arr[smallerP.x][smallerP.y]==65535 || arr[smallerP.x][smallerP.y]==65534 ) && arr[smallerP.x][smallerP.y]!=65533){
                    if ( Math.abs(smallerP.x-x)>0) {
                    
                    arr[smallerP.x][smallerP.y]=(char)-1;
                    }
                    else
                    arr[smallerP.x][smallerP.y]=(char)-3;
                    }
                }
                else if( Math.abs(smallerP.y-y)>0){
                    smallerP.y--;
                   
                    if(smallerP.y >= 0 &&( arr[smallerP.x][smallerP.y]==0 || arr[smallerP.x][smallerP.y]==65535 || arr[smallerP.x][smallerP.y]==65534 ) && arr[smallerP.x][smallerP.y]!=65533) {
                    if(Math.abs(smallerP.y-y)>0){
                        if(arr[smallerP.x][smallerP.y]!=65535)
                    arr[smallerP.x][smallerP.y]=(char)-2;
                    }
                    else
                    arr[smallerP.x][smallerP.y]=(char)-3;
                    }
                }

            }
           

           }
         }
       }

       printArray(arr,g.V());
    }
    
    private static void printArray(char arr[][], int size){
            int extra=0;
            if( (size+"").length() >1 ) extra+=(size+"").length()-1;
            for (int i = 0; i < arr.length; i++) {
                int extra1=extra;
                int nExternal=0;
                for (int j = 0; j < arr[i].length; j++) {
                    
                    if (arr[i][j] == '\0') {
                        if(nExternal==0)
                        System.out.print(" ");
                        else nExternal--;

                        while(extra1>0){System.out.print(" "); extra1--;}

                    } else if (arr[i][j] == (char) -1) {
                        System.out.print("|");
                    } 
                    else if (arr[i][j] == (char) -2) {
                         if(nExternal==0)
                        System.out.print("-");
                        else nExternal--;

                        while(extra1>0){System.out.print("-"); extra1--;}
                    }
                    else if (arr[i][j] == (char) -3) {
                        System.out.print("•");
                    }
                    else {
                        System.out.print((int)arr[i][j]);
                        if( ((int)arr[i][j]+"").length()>1 )nExternal+=((int)arr[i][j]+"").length()-1;
                    }
                }
                System.out.println();
            }
        
    }
}
