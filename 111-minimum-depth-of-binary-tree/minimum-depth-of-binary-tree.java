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
    public int minDepth(TreeNode root)
     {
    if(root==null)return 0;
  //  System.out.println(root.val);
    if(root.left==null && root.right==null)return 1;
    int left=root.left==null?Integer.MAX_VALUE:minDepth(root.left);
    int right=root.right==null?Integer.MAX_VALUE:minDepth(root.right);
    return Math.min(left,right)+1;    
    }
}