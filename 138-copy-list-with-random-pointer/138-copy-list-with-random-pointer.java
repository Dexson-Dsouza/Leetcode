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
        Node copyHead=new Node(0);
        
        Node copyList=copyHead;
        Map<Node,Node> oldNewMapping=new HashMap<>();
        
        while(head!=null){
            if(oldNewMapping.containsKey(head)==false){
                oldNewMapping.put(head,new Node(head.val));
            }
            if(head.random!=null && oldNewMapping.containsKey(head.random)==false){
                oldNewMapping.put(head.random,new Node(head.random.val));
            }
            
            Node current = oldNewMapping.get(head);
            if(head.random!=null){
                current.random = oldNewMapping.get(head.random);
            }
            
            copyList.next=current;
            copyList = current;
            head=head.next;
        }
        return copyHead.next;
    }
}