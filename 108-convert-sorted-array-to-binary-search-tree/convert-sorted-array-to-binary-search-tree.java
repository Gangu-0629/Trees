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
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums,0,nums.length-1);
    }
    public TreeNode create(int nums[],int lf,int rt)
    {
        if(lf>rt)return null;
            int mid=(lf+rt)/2;
            TreeNode node=new TreeNode(nums[mid]);
            node.left=create(nums,lf,mid-1);
            node.right=create(nums,mid+1,rt);
            return node;  
    }
}