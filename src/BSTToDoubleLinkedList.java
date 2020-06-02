public class BSTToDoubleLinkedList {

  TreeNode pre = null;
  TreeNode head = null;

  public TreeNode treeToDoublyList(TreeNode root) {
    helper(root);
    head.left = pre;
    pre.right = head;
    return head;
  }

  void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root.left);
    if (head == null) {
      head = root;
    }
    root.left = pre;
    if (pre != null) {
      pre.right = root;
    }
    pre = root;
    helper(root.right);
  }
}
