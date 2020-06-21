import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedInterval {

  public static void main(String[] args) {
    List<Interval> list1 = Arrays.asList(new Interval(1, 2), new Interval(3, 4));
    List<Interval> list2 = Arrays.asList(new Interval(2, 3), new Interval(5, 6));
    System.out.println(mergeTwoInterval(list1, list2));
  }

  public static List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
    int i = 0, j = 0;
    List<Interval> res = new ArrayList<>();
    Interval curr = null;
    while (i < list1.size() && j < list2.size()) {
      if (list1.get(i).start <= list2.get(j).start) {
        if (curr == null || curr.end < list1.get(i).start) {
          curr = list1.get(i);
          res.add(curr);
        } else {
          curr.end = Math.max(curr.end, list1.get(i).end);
        }
        i++;
      } else {
        if (curr == null || curr.end < list1.get(j).start) {
          curr = list1.get(j);
          res.add(curr);
        } else {
          curr.end = Math.max(curr.end, list2.get(j).end);
        }
        j++;
      }
    }
    while (i < list1.size()) {
      if (curr.end < list1.get(i).start) {
        curr = list1.get(i);
        res.add(curr);
      } else {
        curr.end = Math.max(curr.end, list1.get(i).end);
      }
      i++;
    }
    while (j < list2.size()) {
      if (curr.end < list2.get(j).start) {
        curr = list2.get(j);
        res.add(curr);
      } else {
        curr.end = Math.max(curr.end, list2.get(j).end);
      }
      j++;
    }
    return res;
  }
}
