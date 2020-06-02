import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class IsGraphBipartite {

  public static void main(String[] args) {
    int[][] graph = {{1,3}, {0,2},{1,3},{0,2}};
    System.out.println(isBipartite(graph));
    Set<Integer> set = new HashSet<>();
  }
  // O(E+V)
  public static boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] colors = new int[n];
    for (int i = 0; i < n; i++) {
      if (colors[i] == 0 && !validate(graph, colors, i, 1)) {
        return false;
      }
    }
    System.out.println(Arrays.toString(colors));
    return true;
  }

  static boolean validate(int[][] graph, int[] colors, int node, int color) {
    if (colors[node] != 0) {
      return colors[node] == color;
    }
    colors[node] = color;
    for (int next : graph[node]) {
      if (!validate(graph, colors, next, -color)) {
        return false;
      }
    }
    return true;
  }
}
