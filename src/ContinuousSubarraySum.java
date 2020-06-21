import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContinuousSubarraySum {

  public static void main(String[] args) {
    int[] nums = {0, 0};
    System.out.println(checkSubarraySum(nums, 0));
    List[] x = new List[3];
    x[0]=new ArrayList<Integer>();
    x[0].add(1);
    int y = (int) x[0].get(0);
    System.out.println(x[0]);
  }

  public static boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
      put(0, -1);
    }};
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (k != 0) {
        sum %= k;
      }
      if (map.containsKey(sum)) {
        if (i - map.get(sum) > 1) {
          return true;
        }
      } else {
        map.put(sum, i);
      }
    }
    return false;
  }
}
