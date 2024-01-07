class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums=new ArrayList<>();
        for(int n:cards){
            nums.add((double)(n));
        }
        return findIfPoss(nums);
    }
    
    boolean findIfPoss(List<Double> nums){
        if(nums.size()==1){
            // System.out.println(nums.get(0));
            return Math.abs(nums.get(0)- 24.0) < 0.001;
        }
        for(int i=0;i<nums.size();i++){
            for(int j=i+1;j<nums.size();j++){
                Double a = nums.get(i);
                Double b = nums.get(j);
                List<Double> combos=Arrays.asList(new Double[]{a+b,a-b,b-a,a/b,b/a,a*b});
                
                List<Double> clone = new ArrayList<>();
                for(Double num:nums){
                    if(num!=a && num!=b){
                        clone.add(num);
                    }
                }
                
                for(Double combo:combos){
                    clone.add(combo);
                    if(findIfPoss(clone)){
                        return true;
                    }
                    clone.remove(clone.size()-1);
                }
            }
            
        }
        return false;
    }
}