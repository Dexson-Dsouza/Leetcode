/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        connectNeighbours(root,null);
        return root;
    }
    
    public void connectNeighbours(Node left, Node right){
        if(left==null && right==null){
            return;
        }
        
        if(left!=null){
            left.next=right;
            connectNeighbours(left.left,left.right);
        }
        if(right!=null){
            connectNeighbours(right.left,right.right);
        }
        if(left!=null && right!=null){
            connectNeighbours(left.right,right.left);
        }
    }
}