import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

  public static void main(String[] args) {
    System.out.println(canFinish(2, new int[][]{{0,1}}));
    List<Integer> list = new ArrayList<>();
    list.add(1);
    Integer[] a = list.toArray(new Integer[1]);
  }
  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    Queue<Integer> q = new ArrayDeque<>();
    ArrayList[] graph = new ArrayList[numCourses];
    int[] degrees = new int[numCourses];

    for(int[] p : prerequisites){
      degrees[p[0]]++;
      if(graph[p[1]]==null){
        graph[p[1]]=new ArrayList();
      }
      graph[p[1]].add(p[0]);
    }

    for(int i=0;i<numCourses;i++){
      if(degrees[i]==0) q.offer(i);
    }

    int finished = 0;
    while(!q.isEmpty()){
      int curr = q.poll();
      if(graph[curr]!=null){
        for(int i=0;i<graph[curr].size();i++){
          int next = (int)graph[curr].get(i);
          degrees[next]--;
          if(degrees[next] == 0){
            q.offer(next);
          }
        }
      }
      finished++;
    }

    return finished == numCourses;
  }
}
