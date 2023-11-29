class Solution {
    public static void nextPermutation(int[] nums) {
      TreeMap<Integer,Integer> visitedDigits = new TreeMap<>();

      int index = nums.length-1;
      boolean foundReplacement = false;
      while(index>=0 && !foundReplacement){
        int curDigit = nums[index];
        Integer greaterDigit = visitedDigits.higherKey(curDigit);
        visitedDigits.put(curDigit,visitedDigits.getOrDefault(curDigit, 0)+1);
      
        // System.out.println(curDigit+" "+greaterDigit);
        if(greaterDigit!=null){
          foundReplacement=true;
          nums[index]=greaterDigit;
          visitedDigits.put(greaterDigit,visitedDigits.get(greaterDigit)-1);
        }else{
          index--;
        }
      }

      if(foundReplacement){
        //add remaining digits in sorted order
        int i = index+1;
        for(int digit:visitedDigits.keySet()){
          int digitCount = visitedDigits.get(digit);
          // System.out.println(digit+" "+digitCount+" "+i);
          while(digitCount>0){
            nums[i]=digit;
            i++;
            digitCount--;
          }
        }

      }else{
        //reverse
        int[] clonedNums = nums.clone();
        for(int i=0;i<clonedNums.length;i++){
          nums[nums.length-1-i] = clonedNums[i]; 
        }
      }

    }
}