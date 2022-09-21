/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return null;
        }
        
        Node newHead=new Node();
        
        Node currentFlattenNode=newHead;
        Stack<Node> currentNodes=new Stack<>();
        currentNodes.push(head);
        while(currentNodes.size()>0){
            Node currentNode = currentNodes.pop();
            if(currentNode.next!=null){
                currentNodes.push(currentNode.next);
            }
            if(currentNode.child!=null){
                currentNodes.push(currentNode.child);
            }
            currentNode.next=null;
            currentNode.child=null;
            currentFlattenNode.next=currentNode;
            currentNode.prev=currentFlattenNode;
            currentFlattenNode=currentNode;
        }
        newHead=newHead.next;
        newHead.prev=null;
        return newHead;
    }
}