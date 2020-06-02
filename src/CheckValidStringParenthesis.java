import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CheckValidStringParenthesis {

  public static void main(String[] args) {
    String s = "(())((())()()(*)1(*()(())())())()()2((()())((()))(*";
    System.out.println(checkValidString(s));
    List<?> list = foo();
    System.out.println();
  }

  public static boolean checkValidString(String s) {
    int low = 0, high = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        low++;
        high++;
      } else if (c == ')') {
        if (low > 0) {
          low--;
        }
        high++;
      } else {
        if (low > 0) {
          low--;
        }
        high++;
      }
      if (high < 0) {
        return false;
      }

    }
    return low == 0;
  }

  static void getList(List<? extends Number> list){
    System.out.println(list);
  }

  static List<?> foo(){
    List<Integer> list = new ArrayList<>();
    return list;
  }
}
