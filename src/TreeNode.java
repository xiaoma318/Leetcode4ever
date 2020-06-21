public class TreeNode {

  TreeNode left, right;
  int val;

  TreeNode(int v) {
    val = v;
  }

  public static void print(TreeNode node){
    if(node == null) return;
    System.out.print(node.val+" ");
    print(node.left);
    print(node.right);
  }
}
