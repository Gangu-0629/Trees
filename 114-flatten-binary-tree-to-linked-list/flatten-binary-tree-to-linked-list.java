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
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode rightmost=null;
        if(root.left!=null){
            rightmost=findrightmost(root.left);
        }
        if(root.right!=null && rightmost!=null){
            rightmost.right=root.right;
            root.right=null;
            root.right=root.left;
            root.left=null;
        }
        if(root.right==null){
            root.right=root.left;
            root.left=null;
        }
     
        flatten(root.right);
    }
    public TreeNode findrightmost(TreeNode node){
        while(node.right!=null){
            node=node.right;
        }
        return node;
    }
}