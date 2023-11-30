/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer,Node> valueNodeMap=new HashMap<>();
        return cloneNode(node,valueNodeMap);
    }
    
    public Node cloneNode(Node node, Map<Integer,Node> valueNodeMap){
        if(node == null){
            return null;
        }
        if(valueNodeMap.containsKey(node.val)){
            return valueNodeMap.get(node.val);
        }
        
        Node clonedNode = new Node(node.val);
        valueNodeMap.put(node.val,clonedNode);
        for(Node neighbor:node.neighbors){
            clonedNode.neighbors.add(cloneNode(neighbor,valueNodeMap));
        }
        return clonedNode;
    }
}