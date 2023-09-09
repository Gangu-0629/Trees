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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        int maxlev=0;
        int lev=0;
        long maxsum=Long.MIN_VALUE;
        que.offer(root);
        while(!que.isEmpty()){
            int size=que.size();
            long sum=0;
            lev++;
            for(int i=0;i<size;i++){
                TreeNode poped=que.poll();
                if(poped.left!=null) que.offer(poped.left);
                if(poped.right!=null) que.offer(poped.right);
                sum+=poped.val;
            }
            if(sum>maxsum){
                maxsum=sum;
                maxlev=lev;
            }
        }
        return maxlev;

    }
}