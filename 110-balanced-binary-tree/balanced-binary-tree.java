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
    Map<TreeNode,Integer> map=new HashMap<>();
    public boolean isBalanced(TreeNode node) {
        
        if(node==null)return true;
        int left=height(node.left);
        int right=height(node.right);
           // System.out.println(node.val+" with height of "+Math.abs(left-right));
            boolean check=Math.abs(left-right)<=1?true:false;
        return (check && isBalanced(node.left) && isBalanced(node.right));
    }
    public int height(TreeNode node){
        if(node==null)
        {
            return -1;
        }
        if(map.containsKey(node))return map.get(node);
        int left=height(node.left);
        int right=height(node.right);
        int hei=Math.max(left,right)+1;
        map.put(node,hei);
        return hei;
    }
}