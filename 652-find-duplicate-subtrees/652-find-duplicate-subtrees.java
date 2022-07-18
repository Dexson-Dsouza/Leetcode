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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<String> keySet=new HashSet<>();
        Set<String> doneKeys=new HashSet<>();
        List<TreeNode> similarNodes=new ArrayList<>();
        traverse(root,keySet,doneKeys,similarNodes);
        return similarNodes;
    }
    
    String traverse(TreeNode root, Set<String> keySet, Set<String> doneKeys, List<TreeNode> similarNodes){
        if(root==null){
            return "#";
        }
        
        String leftKey=traverse(root.left,keySet,doneKeys,similarNodes);
        String rightKey=traverse(root.right,keySet,doneKeys,similarNodes);
        String currentKey= leftKey+","+rightKey+","+root.val;
        // System.out.println(currentKey);
        if(keySet.contains(currentKey)){
            if(!doneKeys.contains(currentKey)){
                similarNodes.add(root);
                doneKeys.add(currentKey);
            }
        }else{
            keySet.add(currentKey);
        }
        return currentKey;
    }
}