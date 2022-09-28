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
        List<Node> nodeLevelList=new ArrayList<>();
        traverse(root,nodeLevelList,0);
        return root;
    }
    
    public void traverse(Node root, List<Node> nodeLevelList, int level){
        if(root==null){
            return;
        }
        if(nodeLevelList.size()>level){
            nodeLevelList.get(level).next=root;
            nodeLevelList.set(level,root);
        }else{
            nodeLevelList.add(root);
        }
        traverse(root.left,nodeLevelList,level+1);
        traverse(root.right,nodeLevelList,level+1);
    }
}