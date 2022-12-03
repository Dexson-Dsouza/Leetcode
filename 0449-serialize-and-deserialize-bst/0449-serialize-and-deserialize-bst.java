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
    String nullNode = "N";
    String seperator = ",";
    public String serialize(TreeNode root) {
        StringBuilder encodedSb=new StringBuilder();
        encodeTree(root,encodedSb);
        return encodedSb.toString();
    }
    
    public void encodeTree(TreeNode n, StringBuilder sb){
        if(n==null){
            sb.append(nullNode);
            sb.append(seperator);
        }else{
            sb.append(n.val);
            sb.append(seperator);
            encodeTree(n.left,sb);
            encodeTree(n.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values= data.split(seperator);
        Queue<String> valueQueue=new LinkedList<>();
        for(String value:values){
            valueQueue.add(value);
        }
        return decodeTree(valueQueue);
    }
    
    public TreeNode decodeTree(Queue<String> valueQueue){
        if(valueQueue.size()==0){
            return null;
        }
        String val = valueQueue.poll();
        if(val.charAt(0)=='N'){
            return null;
        }
        
        int numericValue = Integer.parseInt(val);
        TreeNode n = new TreeNode(numericValue);
        n.left = decodeTree(valueQueue);
        n.right = decodeTree(valueQueue);
        return n;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;