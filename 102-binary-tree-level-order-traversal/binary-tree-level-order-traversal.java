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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null) return res;
        queue.offer(root);
        while(!queue.isEmpty())
        {
                int no=queue.size();
                LinkedList<Integer> al=new LinkedList<Integer>();
                for(int i=0;i<no;i++)
                {
                    if(queue.peek().left!=null) queue.offer(queue.peek().left);
                    if(queue.peek().right!=null) queue.offer(queue.peek().right);
                    al.add(queue.poll().val);
                }
                res.add(al);
        }
        return res;
    }
}