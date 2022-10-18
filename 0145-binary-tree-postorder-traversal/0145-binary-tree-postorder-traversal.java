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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> orderedList=new ArrayList<>();
        if(root==null){
            return orderedList;
        }
        Stack<TreeNode> nodes=new Stack<>();
        nodes.add(root);
        while(nodes.size()>0){
            TreeNode topNode=nodes.peek();
            if(topNode.left!=null){
                nodes.add(topNode.left);
                topNode.left=null;
            }else if(topNode.right!=null){
                nodes.add(topNode.right);
                topNode.right=null;
            }else{
                nodes.pop();
                orderedList.add(topNode.val);
            }
        }
        return orderedList;
    }
}