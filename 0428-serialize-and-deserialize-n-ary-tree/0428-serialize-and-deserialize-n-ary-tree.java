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

class Codec {
    String splitter=",";
    String NN="N";
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb=new StringBuilder();
        encode(root,sb);
        return sb.toString();
    }
    
    public void encode(Node root, StringBuilder sb){
        if(root==null){
            sb.append(NN);
            sb.append(splitter);
        }else{
            
            sb.append(root.val);
            sb.append(splitter);
            sb.append(root.children.size());
            sb.append(splitter);
            for(Node c:root.children){
                encode(c,sb);
            }
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Deque<String> d=new LinkedList<>(Arrays.asList(data.split(splitter)));
        return decode(d);
    }
    
    public Node decode(Deque<String> d){
        // if(d.size()==0){
        //     return null;
        // }
        String first=d.pollFirst();
        if(first.equals(NN)){
            return null;
        }
        Node n=new Node(Integer.parseInt(first));
        Integer size=Integer.parseInt(d.pollFirst());
        n.children=new ArrayList<>(size);
        
        for(int i=0;i<size;i++){
            n.children.add(decode(d));
        }
        return n;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));