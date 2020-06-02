import java.util.Arrays;
import java.util.Comparator;

public class FriendsOfAppropriateAges {

  public static void main(String[] args) {
    int[] ages = {73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110};
    //int[] ages = {20,30,100,110,120};
    System.out.println(numFriendRequests2(ages));
  }

  public static int numFriendRequests2(int[] ages) {
    int[] count = new int[121];
    for (int age : ages) {
      count[age]++;
    }
    int requests = 0;
    for (int i = 0; i <= 120; i++) {
      for (int j = 0; j <= 120; j++) {
        if (check2(i, j)) {
          if (i == j) {
            requests += count[i] * (count[i] - 1);
          } else {
            requests += count[i] * count[j];
          }
        }
      }
    }
    return requests;
  }

  static boolean check2(int a, int b) {
    return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
  }

  public static int numFriendRequests(int[] ages) {
    int count = 0;
    Arrays.sort(ages);
    System.out.println(Arrays.toString(ages));
    for (int i = ages.length - 1; i >= 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        count += check(ages[i], ages[j]);
      }
    }
    return count;
  }

  static int check(int a, int b) {

    if (b <= a * 0.5 + 7 || (b > 100 && a < 100)) {
      return 0;
    }
    if (a == b) {
      return 2;
    }

    return 1;
  }
}
