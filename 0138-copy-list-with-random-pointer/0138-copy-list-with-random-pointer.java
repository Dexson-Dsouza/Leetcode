/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> copyMap=new HashMap<>();
        return clone(head,copyMap);
    }
    
    public Node clone(Node node, Map<Node,Node> copyMap) {
        if(node==null){
            return null;
        }
        
        if(copyMap.containsKey(node)){
            return copyMap.get(node);
        }
        
        Node copyNode = new Node(node.val);
        copyMap.put(node,copyNode);
        copyNode.next = clone(node.next,copyMap);
        copyNode.random = clone(node.random,copyMap);
        return copyNode;
    }
}