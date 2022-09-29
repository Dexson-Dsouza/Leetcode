class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int currentSum=0;
        for(int i=0;i<k;i++){
            currentSum+=Math.abs(arr[i]-x);
        }
        
        int minDistance = currentSum;
        int start=0;
        
        for(int i=k;i<arr.length;i++){
            currentSum-=Math.abs(arr[i-k]-x);
            currentSum+=Math.abs(arr[i]-x);
            if(currentSum<minDistance){
                minDistance=currentSum;
                start=i-k+1;
            }
            
        }
        List<Integer> closestNumbers=new ArrayList<>();
        for(int i=start;i<start+k;i++){
            closestNumbers.add(arr[i]);
        }
        return closestNumbers;
    }
}