class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int n:sticks){
            pq.add(n);
        }
        int cost = 0;
        while(pq.size()>1){
            int s1 = pq.poll();
            int s2 = pq.poll();
            int sum = s1+s2;
            pq.add(sum);
            cost += sum;
        }
        return cost;
    }
}