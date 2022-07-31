class NumArray {
    int[] bit;
    int[] arr;
    public NumArray(int[] nums) {
        bit=new int[nums.length+1];
        arr=nums;
        for(int i=1;i<=nums.length;i++){
            bit[i]=nums[i-1];
        }
        
        for(int i=1;i<=nums.length;i++){
            int parent = i + (i & -i);
            if(parent<bit.length){
                bit[parent]+=bit[i];
            }
        }
    }
    
    public void update(int index, int val) {
        int i=index+1;
        int diff = val-arr[index];
        arr[index]=val;
        
        while(i<bit.length){
            bit[i]+=diff;
            i =   i + (i & -i);
        }
    }
    
    public int sumRange(int left, int right) {
        return sum(right+1)-sum(left);
    }
    
    int sum(int i){
        int s=0;
        while(i>=1){
            s+=bit[i];
            i -= (i&-i);
        }
        return s;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */