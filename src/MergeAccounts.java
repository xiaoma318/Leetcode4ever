import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MergeAccounts {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, List<Set<String>>> map = new HashMap<>();
    for (List<String> account : accounts) {
      String name = account.get(0);
      Set<String> emails = new HashSet<>(account.subList(1, account.size()));

      if (!map.containsKey(name)) {
        List<Set<String>> list = new ArrayList<>();
        Set<String> set = new TreeSet<>(emails);
        list.add(set);
        map.put(name, list);
      } else {
        boolean exist = false;
        List<Set<String>> setList = new ArrayList<>();
        for (Set<String> set : map.get(name)) {
          if (hasCommon(emails, set)) {
            emails.addAll(set);
            exist = true;
          } else {
            setList.add(set);
          }
        }
        if (!exist) {
          Set<String> set = new HashSet<>(emails);
          setList.add(set);
        } else {
          setList.add(emails);
        }
        map.put(name, setList);
      }
    }
    List<List<String>> res = new ArrayList<>();
    for (Map.Entry<String, List<Set<String>>> e : map.entrySet()) {
      for (Set<String> set : e.getValue()) {
        List<String> list = new ArrayList<>();
        list.add(e.getKey());
        List<String> emails = new ArrayList<>(set);
        list.addAll(emails);
        res.add(list);
      }
    }
    return res;
  }

  boolean hasCommon(Collection<String> a, Set<String> b) {
    for (String x : a) {
      if (b.contains(x)) {
        return true;
      }
    }
    return false;
  }

  public List<List<String>> accountsMerge2(List<List<String>> accounts) {
    Map<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
    Map<String, String> name = new HashMap<>();        //<email, username>
    // Build the graph;
    for (List<String> account : accounts) {
      String userName = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        if (!graph.containsKey(account.get(i))) {
          graph.put(account.get(i), new HashSet<>());
        }
        name.put(account.get(i), userName);

        if (i == 1) {
          continue;
        }
        graph.get(account.get(i)).add(account.get(i - 1));
        graph.get(account.get(i - 1)).add(account.get(i));
      }
    }

    Set<String> visited = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    // DFS search the graph;
    for (String email : name.keySet()) {
      List<String> list = new ArrayList<>();
      if (visited.add(email)) {
        dfs(graph, email, visited, list);
        Collections.sort(list);
        list.add(0, name.get(email));
        res.add(list);
      }
    }

    return res;
  }

  public void dfs(Map<String, Set<String>> graph, String email, Set<String> visited,
      List<String> list) {
    list.add(email);
    for (String next : graph.get(email)) {
      if (visited.add(next)) {
        dfs(graph, next, visited, list);
      }
    }
  }
}
