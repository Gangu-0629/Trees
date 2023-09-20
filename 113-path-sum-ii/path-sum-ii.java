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
    List<List<Integer>> ans=new LinkedList<List<Integer>>();
        List<Integer> al=new LinkedList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
   
        helper(root,targetSum);
        return ans;
    }
    public void helper(TreeNode root,int target){
    
    if(root==null ) return ;
     if(root.left==null && root.right==null && target-root.val==0){    
        al.add(root.val);
        List<Integer> temp=new LinkedList<Integer>(al);
         ans.add(temp);
         al.remove(al.size()-1);
         return;
     }
      
      al.add(root.val);     
      helper(root.left,target-root.val);
      helper(root.right,target-root.val);
      al.remove(al.size()-1);
    }
}