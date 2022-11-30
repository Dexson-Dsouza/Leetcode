class Solution {
    public boolean isPossible(int[] target) {
        if(target.length==1){
            return target[0]==1;
        }
        PriorityQueue<Long> pq=new PriorityQueue<>((a,b)-> Long.compare(b,a));
        long sum=0;
        for(int n:target){
            sum+=n;
            pq.add((long)n);
        }
        
        while(true){
            Long oldTop=pq.poll();
            if(oldTop==1){
                break;
            }
            Long rem=sum-oldTop;
            if(oldTop<=rem){
                return false;
            }
            Long newTop=oldTop-(rem*((int)(oldTop/rem)));
            
            
            if(newTop==0){
                newTop=rem;
            }
            sum = sum - oldTop + newTop;
            pq.add(newTop);
        }
        return true;
    }
}