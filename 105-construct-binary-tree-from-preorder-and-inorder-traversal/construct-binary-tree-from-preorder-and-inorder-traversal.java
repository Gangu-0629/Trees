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
class Solution 
{
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        idx=0;
        return build(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int[] inorder,int low,int high)
    {
         if(low>high)return null;
         int fd=find(inorder,preorder[idx]);
         TreeNode node=new TreeNode(preorder[idx]);
         idx++;
         node.left=build(preorder,inorder,low,fd-1);
         node.right=build(preorder,inorder,fd+1,high);
         return node;
    }
    public int find(int inorder[],int k){
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==k){
                return i;
            }
        }
        return -1;


        }
    }

