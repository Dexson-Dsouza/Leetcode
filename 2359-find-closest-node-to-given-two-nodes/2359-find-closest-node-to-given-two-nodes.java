class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int totalNodes=edges.length;
        
        int[] distanceNode1=new int[totalNodes];
        int[] distanceNode2=new int[totalNodes];
        
        for(int i=0;i<totalNodes;i++){
            distanceNode1[i]=distanceNode2[i]=-1;
        }
        
        explore(edges,node1,distanceNode1);
        explore(edges,node2,distanceNode2);
        
        int closest=-1;
        int minDistance=Integer.MAX_VALUE;
        for(int i=0;i<totalNodes;i++){
            if(distanceNode1[i]>=0 && distanceNode2[i]>=0){
                int curDist=Math.max(distanceNode1[i],distanceNode2[i]);
                if(curDist<minDistance){
                    minDistance=curDist;
                    closest=i;
                }
            }
        }
        return closest;
    }
    
    void explore(int[] edges, int start, int[] distance){
        Set<Integer> visited=new HashSet<>();
        
        int curNode=start;
        int dist=0;
        while(curNode!=-1 && visited.contains(curNode)==false){
            distance[curNode]=dist;
            dist++;
            visited.add(curNode);
            curNode=edges[curNode];
        }
    }
}