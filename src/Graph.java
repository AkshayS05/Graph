import java.util.Scanner;

public class Graph {
    //DFS traversal of a graph
    public static void printHelper(int edges[][],int startVertex, boolean visited[]){
        System.out.println(startVertex);
        visited[startVertex]=true;
        for (int i = 0; i < edges.length ; i++) {
            //check for each block that whether it is 1 or not, if 1 then print it
            //second condition which it should meet is that the block shouldn't be visited
            if (edges[startVertex][i] == 1&&!visited[i]) {
                printHelper(edges, i, visited);
            }
        }
    }
    //this will only print the connected vertices but not the separated ones, thus we need to check if a block is not visited
    //use that as the starting vertex
    public static void print(int edges[][]) {
        boolean visited[] = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printHelper(edges, i, visited);
            }
        }
    }
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Plesse enter number of vertices");
        int v= s.nextInt();
        System.out.println("Please enter number of edges");
        int e= s.nextInt();
        //ones we have number of vertices which are similar to the nodes of the tree
        //and edges i.e connection between two, we can create a 2d matrix to mark that as 1(true)
        int edges[][]= new int[v][v];
        for (int i = 0; i <edges.length ; i++) {
            int fv= s.nextInt(); //represents the first vertex;
            int sv= s.nextInt(); //represents the second vertex;
            //if there is a path between first vertex to the second vertex, then the opposite is also true
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }
        print(edges);
    }
}
