class Solution {
    public static boolean predictTheWinner(int[] nums) {
    int len = nums.length;
    Integer[][] maxScoreRange = new Integer[len][len];
    int maxScore = findMaxScore(nums,0,nums.length-1,maxScoreRange);  
    int totalSum =0 ;
    for(int n:nums){
      totalSum+=n;
    }
    int bobScore = totalSum-maxScore;
    // System.out.println(totalSum+" "+maxScore);
    return maxScore>=bobScore;  
  } 

  public static int findMaxScore(int[] nums, int l, int r, Integer[][] maxScoreRange) {
    if(l>r){
      return 0;
    }
    if(maxScoreRange[l][r]!=null){
      return maxScoreRange[l][r];
    }

    // pick from left
    int leftScore = nums[l]+Math.min(findMaxScore(nums,l+2,r,maxScoreRange),
    findMaxScore(nums,l+1,r-1,maxScoreRange));
    // pick from right
    int rightScore = nums[r]+Math.min(findMaxScore(nums,l+1,r-1,maxScoreRange),
    findMaxScore(nums,l,r-2,maxScoreRange));

    int finalScore = Math.max(leftScore,rightScore);
    maxScoreRange[l][r]=finalScore;
    return finalScore;
  }
}