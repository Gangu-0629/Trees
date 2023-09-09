/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) 
    {
        Queue<Node> que=new LinkedList<Node>();
        List<List<Integer>> al=new LinkedList<List<Integer>>();
        if(root==null) return al;
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> ls=new LinkedList<Integer>();
            for(int i=0;i<size;i++){
                Node poped=que.poll();
                que.addAll(poped.children);
                ls.add(poped.val);
            }
            al.add(ls);
        }
        return al;
    }
}