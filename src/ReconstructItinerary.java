import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

  public static void main(String[] args) {
    List<List<String>> list = new ArrayList<>();
    // list.add(Arrays.asList("JFK", "SFO"));
    // list.add(Arrays.asList("JFK", "ATL"));
    // list.add(Arrays.asList("SFO", "ATL"));
    // list.add(Arrays.asList("ATL", "JFK"));
    // list.add(Arrays.asList("ATL", "SFO"));
    list.add(Arrays.asList("JFK","KUL"));
    list.add(Arrays.asList("JFK","NRT"));
    list.add(Arrays.asList("NRT","JFK"));

    //[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
    List<String> ans = findItinerary2(list);
    System.out.println(ans);
    ArrayList[] lists = new ArrayList[2];
    ArrayList l = lists[1];
    l = new ArrayList();
    l.add(1);
    System.out.println(Arrays.toString(lists));
  }

  public static List<String> findItinerary(List<List<String>> tickets) {
    Map<String, List<String>> map = new HashMap<>();
    for (List<String> t : tickets) {
      map.putIfAbsent(t.get(0), new LinkedList<>());
      map.get(t.get(0)).add(t.get(1));
    }
    for(List<String> list : map.values()){
      Collections.sort(list);
    }
    int n = tickets.size() + 1;
    String[] buff = new String[n];
    buff[0] = "JFK";
    dfs("JFK", map, buff, 1);
    return Arrays.asList(buff);
  }

  static void dfs(String from, Map<String, List<String>> map, String[] buff, int index) {
    if (index == buff.length || !map.containsKey(from)) {
      return;
    }

    for (int i=0;i<map.get(from).size();i++) {
      if(buff[buff.length-1] != null) return;
      String to = map.get(from).remove(i);
      buff[index] = to;
      dfs(to, map, buff, index + 1);
      map.get(from).add(i, to);
    }
  }

  static Map<String, PriorityQueue<String>> flights;
  static LinkedList<String> path;

  static List<String> findItinerary2(List<List<String>> tickets) {
    flights = new HashMap<>();
    path = new LinkedList<>();
    for (List<String> ticket : tickets) {
      flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
      flights.get(ticket.get(0)).add(ticket.get(1));
    }
    dfs2("JFK");
    return path;
  }

  static void dfs2(String departure) {
    PriorityQueue<String> arrivals = flights.get(departure);
    while (arrivals != null && !arrivals.isEmpty())
      dfs2(arrivals.poll());
    path.addFirst(departure);
  }
}
