
class Solution {
    public static int threeSumClosest(int[] nums, int target) {
      int closestDist = Integer.MAX_VALUE;
      int closestSum = -1;
      Arrays.sort(nums);
      for(int index=0;index<nums.length;index++){
        int firstNum = nums[index];
        int secondIndex = index+1;
        int thridIndex = nums.length-1;
        while(secondIndex<thridIndex){
          int curSum = firstNum + nums[secondIndex] + nums[thridIndex];
          int distance = Math.abs(curSum - target);
          if(distance<closestDist){
            closestDist=distance;
            closestSum=curSum;
          }
          if(curSum>=target){
            thridIndex--;
          }else{
            secondIndex++;
          }
        }
      }
      
      return closestSum;
    }
}
