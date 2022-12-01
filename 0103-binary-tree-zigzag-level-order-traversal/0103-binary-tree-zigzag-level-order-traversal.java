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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagLevelOrderList=new ArrayList<>();
        Map<Integer,List<Integer>> levelNodeMap=new HashMap<>();
        traverse(root,0,levelNodeMap);
        List<Integer> levels = new ArrayList<>(levelNodeMap.keySet());
        Collections.sort(levels);
        boolean reverse=false;
        for(int level:levels){
            List<Integer> levelNodes=levelNodeMap.get(level);
            if(reverse){
                Collections.reverse(levelNodes);
            }
            reverse = !reverse;
            zigzagLevelOrderList.add(levelNodes);
        }
        return zigzagLevelOrderList;
    }
    
    void traverse(TreeNode root, int level, Map<Integer,List<Integer>> levelNodeMap){
        if(root==null){
            return;
        }
        if(levelNodeMap.containsKey(level)==false){
            levelNodeMap.put(level,new ArrayList<>());
        }
        levelNodeMap.get(level).add(root.val);
        traverse(root.left,level+1,levelNodeMap);
        traverse(root.right,level+1,levelNodeMap);
    }
}