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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTree=new ArrayList<>();
        if(root==null){
            return levelOrderTree;
        }
        Queue<TreeNode> levelNodes=new LinkedList<>();
        levelNodes.add(root);
        while(levelNodes.size()>0){
            List<Integer> currentLevelValues=new ArrayList<>();
            int curSize=levelNodes.size();
            while(curSize>0){
                curSize--;
                TreeNode currentNode=levelNodes.poll();
                currentLevelValues.add(currentNode.val);
                if(currentNode.left!=null){
                    levelNodes.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    levelNodes.add(currentNode.right);
                }
            }
            levelOrderTree.add(currentLevelValues);
        }
        return levelOrderTree;
    }
}