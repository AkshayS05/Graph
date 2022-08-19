import java.util.ArrayList;
import java.util.Scanner;

public class GetPath {
    private static ArrayList<Integer> getPath(int[][] edges, int v1, int v2) {
        //create a visited array which will keep a track of the vertices already visisted
        boolean visited[]= new boolean[edges.length];
        //call the helper function in which we are also passing this visited array
                return getPath(edges,v1,v2,visited);
    }
        private static ArrayList<Integer> getPath(int[][] edges, int v1, int v2, boolean visited[]) {
        //in case the given start and end points are same, we do not need to travel,hence return the start or end
            //in the list
        if(v1==v2){
            ArrayList<Integer>ans= new ArrayList<>();
            ans.add(v2);
            return ans;
        }
        //else mark the starting point as visited and find the remaining path
        visited[v1]=true;
        for (int i = 0; i <edges.length ; i++) {
            //for the rest of the vertices, if there is a path we will look for the destination
            if(!visited[i]&&edges[v1][i]==1){
                ArrayList<Integer>output= getPath(edges,i,v2,visited);
                //if we find a result, add it in the list and return from where it was called.
                if(output!=null){
                    output.add(v1);
                    return output;
                }
            }
        }
        //if we do not find a path, then return null.
        return null;
    }
    //////////////////////////////////////////////////////////////////////////////////

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
        System.out.println("Enter the source");
        int v1=s.nextInt();
        System.out.println("Enter the destination");
        int v2=s.nextInt();
      ArrayList<Integer> ans=getPath(edges,v1,v2);
        System.out.println(ans);
    }
}

