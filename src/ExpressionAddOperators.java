import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionAddOperators {

  public static void main(String[] args) {

    System.out.println(addOperators("105", 5));
  }

  public static List<String> addOperators(String num, int target) {
    List<String> res = new ArrayList<>();
    //helper(num, target, 0, "", res);
    add(num, target, 0, 0, 0, "", res);
    return res;
  }

  static void helper(String num, int target, int index, String exp, List<String> res) {
    if (index == num.length()) {
      if (eval(exp) == target) {
        res.add(exp);
      }
      return;
    }
    for (int i = index; i < num.length(); i++) {
      if (num.charAt(index) == '0' && i > index) {
        return;
      }
      String substr = num.substring(index, i + 1);
      if (index == 0) {
        helper(num, target, i + 1, substr, res);
      } else {
        helper(num, target, i + 1, exp + "+" + substr, res);
        helper(num, target, i + 1, exp + "-" + substr, res);
        helper(num, target, i + 1, exp + "*" + substr, res);
      }
    }
  }

  static void add(String num, int target, int index, long diff, long curr, String exp,
      List<String> res) {
    if (index == num.length()) {
      if (curr == target) {
        res.add(exp);
      }
      return;
    }
    for (int i = index; i < num.length(); i++) {
      if (num.charAt(index) == '0' && i != index) {
        return;
      }
      String str = num.substring(index, i + 1);
      long val = Long.parseLong(str);
      if (index == 0) {
        add(num, target, i + 1, val, val, str, res);
      } else {
        add(num, target, i + 1, val, curr + val, exp + "+" + str, res);
        add(num, target, i + 1, -val, curr - val, exp + "-" + str, res);
        add(num, target, i + 1, diff * val, curr - diff + diff * val, exp + "*" + str, res);
      }
    }
  }

  static long eval(String exp) {
    Stack<Long> stack = new Stack<>();
    long num = 0;
    char op = '+';
    for (int i = 0; i < exp.length(); i++) {
      char c = exp.charAt(i);
      if (Character.isDigit(c)) {
        num = num * 10 + Character.getNumericValue(c);
      } else {
        if (op == '+') {
          stack.push(num);
        } else if (op == '-') {
          stack.push(-num);
        } else {
          stack.push(stack.pop() * num);
        }
        num = 0;
        op = c;
      }
    }
    if (op == '+') {
      stack.push(num);
    } else if (op == '-') {
      stack.push(-num);
    } else {
      stack.push(stack.pop() * num);
    }
    long res = 0;
    while (!stack.isEmpty()) {
      res += stack.pop();
    }
    return res;
  }
}
