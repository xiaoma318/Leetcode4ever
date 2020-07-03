import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TaskScheduler {

  public static void main(String[] args) {
    char[] task = {'A', 'A', 'A', 'B', 'B', 'B'};
    String s = "AAAAAABCDEFG";

     System.out.println(leastInterval(task, 3));


  }

  public static int leastInterval1(char[] tasks, int n) {
    HashMap<Character, Integer> map = new HashMap<>();
    for(char task : tasks){
      map.putIfAbsent(task, 0);
      map.put(task, map.get(task)+1);
    }

    List<Map.Entry<Character, Integer>> list = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
        Collectors.toList());

    int count = 0;
    int res = 0;
    while(count < tasks.length){
      int k = Math.max(list.size(), n);
      int size = list.size();
      List<Map.Entry<Character, Integer>> newList = new ArrayList<>();
      for(int i=0;i<k;i++){

        if(i<size){
          Map.Entry<Character, Integer> entry = list.get(i);
          if(entry.getKey() > 1){
            entry.setValue(entry.getValue()-1);
            newList.add(entry);
          }
          count++;
        }

        res++;
        if(newList.isEmpty()) break;
      }
      list = newList;
    }

    return res;
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
