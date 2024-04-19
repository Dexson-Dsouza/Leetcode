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
        String code = encode(root);
        return code;
    }
    
    String encode(TreeNode root){
        if(root==null){
            return "N";
        }
        String leftKey = encode(root.left);
        String rightKey = encode(root.right);
        return String.valueOf(root.val)+","+leftKey+","+rightKey;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q=new LinkedList(Arrays.asList(data.split(",")));
        return decode(q);
    }
    
    TreeNode decode(Queue<String> q){
        String node=q.poll();
        if(node.equals("N")){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(node));
        root.left=decode(q);
        root.right=decode(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));