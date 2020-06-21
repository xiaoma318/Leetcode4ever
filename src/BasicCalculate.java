import java.util.ArrayDeque;
import java.util.Stack;

public class BasicCalculate {

  public static void main(String[] args) {
    System.out.println(calculate("3+2*2"));
  }

  public static int calculate(String s) {
    ArrayDeque<Integer> nums = new ArrayDeque<>();
    ArrayDeque<Character> ops = new ArrayDeque<>();
    int last = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '+' || c == '-' || c == '*' || c == '/') {
        if (!ops.isEmpty()) {
          char op = ops.peekLast();
          if (op == '*' || op == '/') {
            int x = nums.pollLast();
            ops.pollLast();
            last = op == '*' ? x * last : x / last;
          }
        }
        ops.offer(c);
        nums.offer(last);
        last = 0;
      } else if (c == ' ') {
        continue;
      } else {
        last = last * 10 + (c - '0');
      }
    }
    if (!ops.isEmpty() && (ops.peekLast() == '*' || ops.peekLast() == '/')) {
      int x = nums.pollLast();
      last = ops.pollLast() == '*' ? x * last : x / last;
    }
    if (ops.isEmpty()) {
      return last;
    }

    nums.offer(last);
    int pre = nums.poll();
    while (!ops.isEmpty()) {
      int x = nums.poll();
      char op = ops.poll();
      if (op == '+') {
        pre += x;
      } else {
        pre -= x;
      }
    }
    return pre;
  }
}
