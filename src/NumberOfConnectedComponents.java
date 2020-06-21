import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class NumberOfConnectedComponents {

  public static void main(String[] args) {
    int[][] edges = {{0, 1}, {1, 2}, {3, 4}, {0,2}};
    countComponents(5, edges);

    List<int[]> list = new ArrayList<>();
    list.add(new int[]{1});
    int[][] arr = list.toArray(new int[0][0]);

  }
  public static int countComponents(int n, int[][] edges) {
    int count = 0;
    ArrayList<Integer>[] adjListArray = new ArrayList[n];
    for(int i=0;i<n;i++){
      adjListArray[i] = new ArrayList<>();
    }

    for(int[] edge : edges){
      adjListArray[edge[0]].add(edge[1]);
      adjListArray[edge[1]].add(edge[0]);
    }

    boolean[] visited = new boolean[n];
    for(int i=0;i<n;i++){
      if(!visited[i]){
        count++;
        dfs(adjListArray, i, visited);
      }
    }
    return count;
  }

  static void dfs(ArrayList<Integer>[] adj, int i, boolean[] visited){
    if(visited[i]) return;
    visited[i] = true;
    for(int j : adj[i]){
      dfs(adj, j, visited);
    }
  }

  public static int countComponents2(int n, int[][] edges) {
    int count = n;

    int[] root = new int[n];
    // initialize each node is an island
    for(int i=0; i<n; i++){
      root[i]=i;
    }

    for(int i=0; i<edges.length; i++){
      int x = edges[i][0];
      int y = edges[i][1];

      int xRoot = getRoot(root, x);
      int yRoot = getRoot(root, y);

      if(xRoot!=yRoot){
        count--;
        root[xRoot]=yRoot;
      }

    }

    return count;
  }

  static int getRoot(int[] arr, int i){
    while(arr[i]!=i){
      arr[i]= arr[arr[i]];
      i=arr[i];
    }
    return i;
  }
}
