public class InsertIntoCyclicSortedList {

  public static void main(String[] args) {
    ListNode n1 = new ListNode(3);
    ListNode n2 = new ListNode(5);
    ListNode n3 = new ListNode(1);
    ListNode n4 = new ListNode(2);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n1;
    printCycle(n1);
    ListNode n5 = insert(n1, 7);
    printCycle(n5);
  }

  public static ListNode insert(ListNode node, int x) {
    ListNode newNode = new ListNode(x);
    if (node == null) {
      newNode.next = newNode;
      return newNode;
    }

    ListNode prev = node;
    ListNode curr = node.next;
    ListNode maxPrev = prev;
    ListNode maxCurr = curr;
    while (curr != node) {
      if (prev.val <= x && curr.val > x) {
        prev.next = newNode;
        newNode.next = curr;
        return newNode;
      }
      if(maxPrev.val <= prev.val){
        maxPrev = prev;
        maxCurr = curr;
      }
      prev = curr;
      curr = prev.next;
    }
    System.out.println(maxPrev.val);
    System.out.println(maxCurr.val);
    maxPrev.next = newNode;
    newNode.next = maxCurr;
    return newNode;
  }

  static void printCycle(ListNode node) {
    ListNode curr = node;
    while (true) {
      System.out.print(curr.val + "->");
      curr = curr.next;
      if (curr == node) {
        System.out.println();
        return;
      }
    }

  }

  static ListNode reverse(ListNode node) {
    ListNode prev = null;
    ListNode curr = node;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
