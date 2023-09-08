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
    public List<Double> averageOfLevels(TreeNode root)
     {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<Double> res=new LinkedList<Double>();
        if(root==null) return res;
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            long sum=0;
            for(int i=0;i<size;i++)
            {
                TreeNode poped=queue.poll();
                if(poped.left!=null) queue.add(poped.left);
                if(poped.right!=null) queue.add(poped.right);
                sum+=poped.val;
            }
            res.add(((double)sum/size));
        }
        return res;
    }
}