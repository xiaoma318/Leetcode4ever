import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

  /**
   * Implement a stack with basic functionality (push and pop) using queues to store the data.
   */
//  b: 1
  Queue<Integer> a = new LinkedList<>();
  Queue<Integer> b = new LinkedList<>();

  public void push(int val) {
    a.offer(val);
  }

  public void push1(int val) {
    while (!a.isEmpty()) {
      b.offer(a.poll());
    }
    a.offer(val);
    while (!b.isEmpty()) {
      a.offer(b.poll());
    }
  }

  public int pop() throws Exception {
    if (a.isEmpty() && b.isEmpty()) {
      throw new Exception("no element");
    }
    while (a.size() > 1) {
      b.offer(a.poll());
    }
    int result = a.poll();
    while (!b.isEmpty()){
      a.offer(b.poll());
    }

    return result;
  }

  public int pop1() throws Exception {
    if (a.isEmpty() && b.isEmpty()) {
      throw new Exception("no element");
    }

    return a.poll();
  }

  public static void main(String[] args) throws Exception {
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);

    System.out.println(stack.pop());
    stack.push(3);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    //System.out.println(stack.pop());
    // stack.push1(1);
    // stack.push1(2);
    //
    //
    // stack.push1(3);
    // stack.push1(3);
    // System.out.println(stack.pop1());
    // System.out.println(stack.pop1());
    // System.out.println(stack.pop1());
    // System.out.println(stack.pop1());
  }

}
