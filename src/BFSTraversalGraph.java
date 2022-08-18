import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSTraversalGraph {
    private static void printLevelOrderHelper(int[][] edges,int sv, boolean visited[]) {
        //queue to add vertex at every level
        Queue<Integer> queue= new LinkedList<>();
        //we will add the 0th vertex and mark it as true
        queue.add(sv);
        visited[sv]=true;
        while(!queue.isEmpty()){
            //now take out the ist element from the queue
            System.out.println(queue.poll());
            //check the edges connected to the vertex
            for (int i = 0; i < edges.length ; i++) {
                if(edges[sv][i]==1&&!visited[i]){
                    //add them in the queue
                    queue.add(i);
                    //mark them as true so that we do not visit them again and get stuck in the loop.
                    visited[i]=true;
                }
            }
        }
    }
    private static void printLevelOrder(int[][] edges) {
        boolean visited[]= new boolean[edges.length];
        //using a loop so that we can also keep a track of those vertices which are connected together but not
        //to the whole.
        for (int i = 0; i < edges.length ; i++) {
            if(!visited[i]){
                printLevelOrderHelper(edges,i,visited);
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the number of vertices");
        int v= s.nextInt();
        System.out.println("Please enter the number of edges");
        int e= s.nextInt();
        //create a 2d matrix of the size v X v
        int edges[][]= new int[v][v];
        for (int i = 0; i < edges.length ; i++) {
            System.out.println("Please enter the first vertex");
            int fv= s.nextInt();
            System.out.println("Please enter the second vertex");
            int sv= s.nextInt();
            //mark that block as 1, which defines it as true
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }
        printLevelOrder(edges);
    }


}
