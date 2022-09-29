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
class valueLevelPair{
    int val;
    int level;
    valueLevelPair(int val, int level){
        this.val=val;
        this.level=level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<valueLevelPair>> colMap=new HashMap<>();
        getAllColumnNodes(root,0,0,colMap);
        List<List<Integer>> verticalOrderList=new ArrayList<>();
        
        List<Integer> keys=new ArrayList(colMap.keySet());
        Collections.sort(keys);
        
        for(int key:keys){
            List<valueLevelPair> values=colMap.get(key);
            Collections.sort(values,(a,b)->a.level==b.level?a.val-b.val:a.level-b.level);
            List<Integer> sortedValues=new ArrayList<>();
            for(valueLevelPair p:values){
                sortedValues.add(p.val);
            }
            verticalOrderList.add(sortedValues);
        }
        return verticalOrderList;
    }
    
    void getAllColumnNodes(TreeNode root, int index, int level, Map<Integer,List<valueLevelPair>> colMap){
        if(root==null){
            return;
        }
        
        if(colMap.containsKey(index)==false){
            colMap.put(index,new ArrayList<>());
        }
        colMap.get(index).add(new valueLevelPair(root.val,level));
        getAllColumnNodes(root.left,index-1,level+1,colMap);
        getAllColumnNodes(root.right,index+1,level+1,colMap);
    }
}