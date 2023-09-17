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

    public boolean isBalanced(TreeNode node) {
        
        return height(node)!=-2;
    }
    public int height(TreeNode node){
        if(node==null)
        {
            return -1;
        }
 
        int left=height(node.left);
        int right=height(node.right);
    if(left==-2||right==-2)return -2;//unbalanaced due there is unbalanced subtree in left or right
    if(Math.abs(left-right)>1)return -2;//unbalanced due to height dif
        return Math.max(left,right)+1;
    }
}