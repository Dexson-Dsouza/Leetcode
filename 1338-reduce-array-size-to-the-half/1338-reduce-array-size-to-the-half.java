class Solution {
    public int minSetSize(int[] arr) {
        int halfSize=arr.length/2;
        Map<Integer,Integer> count=new HashMap<>();
        for(int n:arr){
            count.put(n,count.getOrDefault(n,0)+1);
        }
        
        int currentCount=0;
        List<Integer> countList=new ArrayList<>(count.values());
        Collections.sort(countList,Collections.reverseOrder());
        int setSize=0;
        // System.out.println(countList);
        for(int cnt:countList){
            currentCount+=cnt;
            setSize++;
            if(currentCount>=halfSize){
                break;
            }
        }
        return setSize;
    }
}