public class ListNode {

  int val;
  ListNode next;

  ListNode(int v) {
    val = v;
  }

  static void print(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " -> ");
      node = node.next;
    }
    System.out.println();
  }
}
