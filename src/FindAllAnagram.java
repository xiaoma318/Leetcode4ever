import java.util.ArrayList;
import java.util.List;

public class FindAllAnagram {

  public static void main(String[] args) {
    String s = "abab";
    String p = "ab";
    System.out.println(findAnagrams2(s, p));
    System.out.println(10*0.5);
  }

  static List<Integer> findAnagrams2(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int[] letters = new int[128];
    int n = p.length();

    for (int i = 0; i < n; i++) {
      letters[p.charAt(i)]++;
    }

    for (int left = 0, right = 0, count = 0; right < s.length(); right++) {
      if (letters[s.charAt(right)]-- > 0) {
        count++;
      }

      if (count == n) {
        res.add(left);
      }

      if (right - left + 1 == n) {
        if (letters[s.charAt(left)]++ >= 0) {
          count--;
        }
        left++;
      }
    }

    return res;
  }

  public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int start = 0;
    int[] needFind = new int[128];
    int[] find = new int[128];

    int n = p.length();
    for (int i = 0; i < n; i++) {
      needFind[p.charAt(i)]++;
    }
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (needFind[c] > 0) {
        find[c]++;
        count++;
        if (needFind[c] < find[c]) {
          while (start < i && needFind[c] < find[c]) {
            if (needFind[s.charAt(start)] > 0) {
              count--;
            }
            find[s.charAt(start)]--;
            start++;
          }
        }
        if (count == n) {
          res.add(start);
        }
      } else {
        find = new int[128];
        start = i + 1;
        count = 0;
      }
    }
    return res;
  }
}
