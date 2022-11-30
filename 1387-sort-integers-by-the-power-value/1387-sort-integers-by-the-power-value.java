class Solution {
    public int getKth(int lo, int hi, int k) {
        Map<Integer,Integer> powerMap = new HashMap<>();
        powerMap.put(1,0);
        for(int i=lo;i<=hi;i++){
            findPower(i,powerMap);
        }
        
        int[][] nums=new int[hi-lo+1][2];
        for(int i=lo;i<=hi;i++){
            int index=i-lo;
            nums[index][0] = i;
            nums[index][1] = findPower(i,powerMap);
        }
        return quickSelect(nums,0,nums.length-1,k-1);
    }
    
    int quickSelect(int[][] nums, int left, int right, int k){
        int pivot = findPivot(nums,left,right);
        if(pivot==k){
            return nums[pivot][0];
        }
        
        if(pivot<k){
            return quickSelect(nums,pivot+1,right,k);
        }else{
            return quickSelect(nums,left,pivot-1,k);
        }
    }
    
    int findPivot(int[][] nums, int left, int right){
        // if(left>=right){
        //     return nums[left][0];
        // }
        int pivotPower = nums[right][1];
        int pivotNum = nums[right][0];
        int k = left;
        int i = left;
        while(i<right){
            int pow = nums[i][1];
            int num = nums[i][0];
            if(pow < pivotPower ||(pow == pivotPower && num<pivotNum)){
                int[] t = nums[k];
                nums[k] = nums[i];
                nums[i] = t;
                k++;
            }
            i++;
        }
        int pow = nums[k][1];
        int n = nums[k][0];
        nums[k][0] = nums[right][0];
        nums[k][1] = nums[right][1];
        nums[right][0] = n; 
        nums[right][1] = pow; 
        return k;
    }
    
    public int findPower(int n, Map<Integer,Integer> powerMap){
        if(powerMap.containsKey(n)){
            return powerMap.get(n);
        }
        int power;
        if(n%2==0){
            power = 1 + findPower(n/2,powerMap);
        }else{
            power = 1 + findPower(3*n+1,powerMap);
        }
        powerMap.put(n,power);
        return power;
    }
}