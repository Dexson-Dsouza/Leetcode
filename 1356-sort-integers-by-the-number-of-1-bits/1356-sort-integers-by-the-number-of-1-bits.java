class Solution {
    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        Map<Integer,Integer> oneCountMap = new HashMap<>();
        Integer[] sortedArr=new Integer[len];
        for(int i=0;i<len;i++){
            int n = arr[i];
            sortedArr[i] = n;
            int count = 0;
            while(n!=0){
                if(n%2==1){
                    count++;
                }
                n/=2;
            }
            
            oneCountMap.put(arr[i],count);
        }
        
        Arrays.sort(sortedArr, new Comparator<>(){
            public int compare(Integer a, Integer b){
                int countA = oneCountMap.get(a);
                int countB = oneCountMap.get(b);
            return countA == countB ? a-b : countA-countB;
            }
        });
        int[] sortedIntArr = new int[len];
        
        for(int i=0;i<len;i++){
            sortedIntArr[i] = sortedArr[i];
        }
        return sortedIntArr;
    }
}