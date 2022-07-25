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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null){
            return null;
        }
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        List<List<TreeNode>> nodeLevelList=new ArrayList<>();
        traverse(root,parent,nodeLevelList,0);
        List<TreeNode> deepestNode=nodeLevelList.get(nodeLevelList.size()-1);
        while(deepestNode.size()>1){
            int curSize=deepestNode.size();
            Set<TreeNode> nextUpperLevel=new HashSet<>();
            for(TreeNode node:deepestNode){
                nextUpperLevel.add(parent.get(node));
            }
            deepestNode=new ArrayList<>(nextUpperLevel);
        }
        return deepestNode.get(0);
    }
    
    void traverse(TreeNode root, Map<TreeNode,TreeNode> parent, List<List<TreeNode>> nodeLevelList, int level){
        if(root==null){
            return;
        }
        
        if(nodeLevelList.size()==level){
            nodeLevelList.add(new ArrayList<>());
        }
        nodeLevelList.get(level).add(root);
        
        if(root.left!=null){
            parent.put(root.left,root);
            traverse(root.left,parent,nodeLevelList,level+1);
        }
        if(root.right!=null){
            parent.put(root.right,root);
            traverse(root.right,parent,nodeLevelList,level+1);
        }
    }
}