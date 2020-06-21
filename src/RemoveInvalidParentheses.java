import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RemoveInvalidParentheses {

  public static void main(String[] args) {
   // System.out.println(removeInvalidParentheses1("()()()"));
    Scanner in = new Scanner(System.in);
    int a, b, sum;
    while((a=in.nextInt()) != -1){
      b = in.nextInt();

      System.out.printf("%d %d\n",a, b);
    }

    Set<String> set = new TreeSet<>();
    set.iterator().next();
  }

  public static List<String> removeInvalidParentheses(String s) {
    Queue<String> queue = new ArrayDeque<>();
    List<String> ans = new ArrayList<>();
    HashSet<String> visited = new HashSet<>();
    queue.offer(s);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String curr = queue.poll();
        if (visited.add(curr)) {
          if (isValid(curr)) {
            ans.add(curr);
          }
          if (ans.isEmpty()) {
            for (int j = 0; j < curr.length(); j++) {
              if (curr.charAt(j) == '(' || curr.charAt(j) == ')') {
                queue.offer(curr.substring(0, j) + curr.substring(j + 1));
              }
            }
          }
        }
      }
    }
    return ans;
  }

  static boolean isValid(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        count++;
      } else if (c == ')') {
        if (count <= 0) {
          return false;
        }
        count--;
      }
    }
    return count == 0;
  }

  public static List<String> removeInvalidParentheses1(String s) {
    List<String> ans = new ArrayList<>();
    remove(s, ans, 0, 0, new char[]{'(', ')'});

    return ans;
  }

  static void remove(String s, List<String> ans, int lastI, int lastJ, char[] pair) {
    int counter = 0;
    for (int i = lastI; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == pair[0]) {
        counter++;
      }
      if (c == pair[1]) {
        counter--;
      }
      if (counter >= 0) {
        continue;
      }

      for (int j = lastJ; j <= i; j++) {
        if (s.charAt(j) == pair[1] && (j == lastJ || s.charAt(j - 1) != pair[1])) {
          remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, pair);
        }
      }

      return;
    }
    String reversed = new StringBuilder(s).reverse().toString();
    if (pair[0] == '(') {
      remove(reversed, ans, 0, 0, new char[]{')', '('});
    } else {
      ans.add(reversed);
    }
  }
}
