class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> remainderCountMap = new HashMap<>();
        remainderCountMap.put(0,1);
        int curSum = 0;
        int resultCount = 0;
        for(int n:nums){
            curSum += n;
            int remainder = curSum%k;
            if(remainder<0){
                remainder+=k;
            }
            // System.out.println(remainder + " "+ curSum);
            int prevCount = remainderCountMap.getOrDefault(remainder,0);
            resultCount += prevCount;
            remainderCountMap.put(remainder,prevCount+1);
        }
        return resultCount;
    }
}

/*
[4,5,0,-2,-3,1] k = 5

4
0 -> 1
s = 4
r = 4
c = 0

5
0 = 1 ; 4 =1
s = 9
r = 4
c = 1

0 = 1 ; 4 =2
0
s = 9
r = 4
c = 3

0 = 1 ; 4 =3
-2
s = 7 
r = 3
c = 3

0 = 1 ; 4 =3 ; 3 = 1
-3
s = 4
r = 4
c = 6

0 = 1 ; 4 = 4 ; 3 = 1
1
s = 5
r = 0
c = 7
*/