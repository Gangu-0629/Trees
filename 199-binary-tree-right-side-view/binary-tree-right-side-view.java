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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> al=new LinkedList<Integer>();
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        if(root==null) return al;
        que.offer(root);
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++)
            {
               TreeNode poped=que.poll();
               if(poped.left!=null) que.offer(poped.left);
               if(poped.right!=null) que.offer(poped.right);
               if(i==size-1) al.add(poped.val);
            }
        }
        return al;
    }
}