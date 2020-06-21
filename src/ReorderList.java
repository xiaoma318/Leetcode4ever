import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorderList {

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    n1.next = n2;
    n2.next = n3;
   // n3.next = n4;
    reorderList(n1);
    ListNode.print(n1);
    PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
    q.offer(1);
    q.offer(2);
    System.out.println(q.peek());
  }
  public static void reorderList(ListNode head) {
    ListNode fast = head, slow = head, prev = null;
    while(fast != null && fast.next != null){
      fast = fast.next.next;
      prev = slow;
      slow = slow.next;
    }
    if(fast != null){
      prev = slow;
      slow = slow.next;
    }
    prev.next = null;

    prev = null;
    while(slow != null){
      ListNode next = slow.next;
      slow.next = prev;
      prev = slow;
      slow = next;
    }

    while(prev != null){
      ListNode next = head.next;
      ListNode next1 = prev.next;
      head.next = prev;
      prev.next = next;
      head = next;
      prev = next1;
    }
  }
}
