import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

  public static void main(String[] args) {
    char[] task = {'A', 'A', 'A', 'B', 'B', 'B'};
    String s = "AAAAAABCDEFG";

    System.out.println(leastInterval3(s.toCharArray(), 2));
  }

  public static int leastInterval(char[] tasks, int n) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : tasks) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());

    int length = 0;
    while (!map.isEmpty()) {
      pq.addAll(map.entrySet());
      for (int i = 0; i <= n; i++) {
        if (!pq.isEmpty()) {
          Map.Entry<Character, Integer> top = pq.poll();
          if (top.getValue() == 1) {
            map.remove(top.getKey());
          } else {
            top.setValue(top.getValue() - 1);
          }
        }
        length++;
        if (map.isEmpty()) {
          break;
        }
      }
      pq.clear();
    }
    return length;
  }

  static int leastInterval2(char[] tasks, int n) {
    int[] fraq = new int[26];
    for (char c : tasks) {
      fraq[c - 'A']++;
    }
    Arrays.sort(fraq);
    int i = 24;
    while (i >= 0 && fraq[i] == fraq[25]) {
      i--;
    }
    return Math.max(tasks.length, (fraq[25] - 1) * (n + 1) + 25 - i);
  }

  static int leastInterval3(char[] tasks, int n) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : tasks) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());
    pq.addAll(map.entrySet());
    int length = 0;
    while (!pq.isEmpty()) {
      int k = n+1;
      List<Map.Entry<Character, Integer>> list = new ArrayList<>();
      while(k>0 && !pq.isEmpty()){
        Map.Entry<Character, Integer> top = pq.poll();
        if(top.getValue() > 1){
          top.setValue(top.getValue()-1);
          list.add(top);
        }
        k--;
        length++;
      }

      pq.addAll(list);
      if(pq.isEmpty()) break;
      length+=k;
    }
    return length;
  }
}
