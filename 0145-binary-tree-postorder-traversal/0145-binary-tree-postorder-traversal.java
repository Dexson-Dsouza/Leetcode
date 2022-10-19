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
            TreeNode cur=nodes.pop();
            orderedList.add(cur.val);
            if(cur.left!=null){
                nodes.add(cur.left);
            }
            if(cur.right!=null){
                nodes.add(cur.right);
            }
        }
        Collections.reverse(orderedList);
        return orderedList;
    }
}