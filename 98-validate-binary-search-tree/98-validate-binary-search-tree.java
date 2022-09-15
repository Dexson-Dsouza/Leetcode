/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class nodeBoundary{
        TreeNode node;
        Integer low;
        Integer high;
        nodeBoundary(TreeNode node, Integer low, Integer high){
            this.low=low;
            this.high=high;
            this.node=node;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        Stack<nodeBoundary> st=new Stack<>();
        st.push(new nodeBoundary(root,null,null));
        while(st.size()>0){
            nodeBoundary currentObject = st.pop();
            TreeNode currentNode=currentObject.node;
            Integer low=currentObject.low;
            Integer high=currentObject.high;
            if(low!=null && currentNode.val<=low){
                return false;
            }
            if(high!=null && currentNode.val>=high){
                return false;
            }
            
            if(currentNode.left!=null){
                st.push(new nodeBoundary(currentNode.left,low,currentNode.val));
            }
            if(currentNode.right!=null){
                st.push(new nodeBoundary(currentNode.right,currentNode.val,high));
            }
        }
        return true;
    }
    
}