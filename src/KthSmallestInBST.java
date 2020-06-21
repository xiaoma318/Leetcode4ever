public class KthSmallestInBST {

  public static void main(String[] args) {
    TreeNode n3 = new TreeNode(3);
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n4 = new TreeNode(4);
    n3.left = n1;
    n3.right = n4;
    n1.right = n2;
    System.out.println(kthSmallest(n3, 1));
  }
  static int count=0;
  static int ans;
  static int kthSmallest(TreeNode root, int k) {
    helper(root,k);
    return ans;
  }

  static void helper(TreeNode root, int k){
    if(root == null){
      return;
    }

    helper(root.left, k);
    count++;
    if(count==k){
      ans=root.val;
      return;
    }
    helper(root.right, k);
  }
}
