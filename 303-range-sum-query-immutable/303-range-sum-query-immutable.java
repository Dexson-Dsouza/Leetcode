class NumArray {
    List<Integer> preSumList;
    public NumArray(int[] nums) {
        preSumList=new ArrayList<>();
        preSumList.add(0);
        for(int n:nums){
            preSumList.add(preSumList.get(preSumList.size()-1) +n);
        }
    }
    
    public int sumRange(int left, int right) {
        return preSumList.get(right+1) - preSumList.get(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */