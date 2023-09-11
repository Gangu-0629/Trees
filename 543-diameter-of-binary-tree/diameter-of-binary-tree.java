/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     int maxlen=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        maxlen=Integer.MIN_VALUE;
        int hieght_root=postorder(root);
        return maxlen;

    }
    public int postorder(TreeNode node){
        if(node==null){
            return -1;
        }
        int way1=postorder(node.left);
        int way2=postorder(node.right);
          maxlen=Math.max(maxlen,way1+way2+2);
        return Math.max(way1,way2)+1;
    }
}