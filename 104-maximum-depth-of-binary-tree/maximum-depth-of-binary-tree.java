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
    public int maxDepth(TreeNode root) {
        return height(root)+1;
    }
    public int height(TreeNode node){
        if(node==null){
            return -1;
        }
        int lt=height(node.left);
        int rt=height(node.right);
        return Math.max(lt,rt)+1;
    }
}