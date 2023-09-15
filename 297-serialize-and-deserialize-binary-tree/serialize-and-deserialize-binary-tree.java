/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> al=new LinkedList<String>();
        doserial(root,al);
        String str=new String();
        for(int i=0;i<al.size()-1;i++){
            str+=al.get(i)+",";
        }
        str+=al.get(al.size()-1);
        return str;
    }
    public void doserial(TreeNode node,List<String> al){
        if(node==null){ al.add("null");
        return ;
        }
        al.add(String.valueOf(node.val));
        doserial(node.left,al);
        doserial(node.right,al);
    }

    // Decodes your encoded data to tree.
    int idx=0;
    public TreeNode deserialize(String data) 
    {
        idx=0;
        String arr[]=data.split(",");
        return dodeserial(arr);
    }
    public TreeNode dodeserial(String arr[])
    {
       if(arr[idx].equals("null")==true || idx>=arr.length) {
           idx++;
          return null;
       }
       TreeNode node=new TreeNode(Integer.parseInt(arr[idx]));
       idx++;
       node.left=dodeserial(arr);
       node.right=dodeserial(arr);
       return node;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));