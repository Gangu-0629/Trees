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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        Deque<TreeNode> deque=new LinkedList<TreeNode>();
        if(root==null)return res;
        boolean flag=true;//normal order 0,reverse order 1
        deque.offer(root);
        while(!deque.isEmpty())
        {
            int size=deque.size();
            List<Integer> al=new LinkedList<Integer>();
            if(flag)//normal order
            {
                for(int i=0;i<size;i++)
                {
                    TreeNode poped=deque.pollFirst();
                    if(poped.left!=null) deque.offerLast(poped.left);
                    if(poped.right!=null) deque.offerLast(poped.right);
                    al.add(poped.val);
                }

                flag=false;
            }
            else//reverse order
            {
                  for(int i=0;i<size;i++)
                {
                    TreeNode poped=deque.pollLast();
                    if(poped.right!=null) deque.offerFirst(poped.right);
                    if(poped.left!=null) deque.offerFirst(poped.left);
                      al.add(poped.val);
                   
                }
                flag=true;
            }
            res.add(al);
        }
        return res;

    }
}