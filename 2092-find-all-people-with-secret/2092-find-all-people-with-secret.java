class dsu{
    int[] parent;
    int[] rank;
    dsu(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=-1;
            rank[i]=0;
        }
    }
    
    void union(int a, int b){
        int pa=find(a);
        int pb=find(b);
        if(pa!=pb){
            if(rank[pa]>=rank[pb]){
                parent[pb]=pa;
                rank[pa]++;
            }else{
                rank[pb]++;
                parent[pa]=pb;
            }
        }
    }
    
    
    int find(int a){
        if(parent[a]==-1){
            return a;
        }
        return parent[a]=find(parent[a]);
    }
    
    void disconnect(int a){
        parent[a] = -1;
    }
}

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        dsu groups=new dsu(n);
        groups.union(0,firstPerson);
        Arrays.sort(meetings,((a,b)->a[2]-b[2]));
        
        Set<Integer> peopleWithSecret=new HashSet<>();
        peopleWithSecret.add(0);
        peopleWithSecret.add(firstPerson);
        int totalMeets=meetings.length;
        for(int i=0;i<totalMeets;i++){
            int curTime=meetings[i][2];
            List<int[]> meetingsList=new ArrayList<>();
            meetingsList.add(meetings[i]);
            while(i+1<totalMeets&& meetings[i+1][2]==curTime){
                meetingsList.add(meetings[i+1]);
                i++;
            }
            
            
            Set<Integer> people=new HashSet<>();
            
            for(int[] meeting:meetingsList){
                // System.out.println(curTime + " "+meeting[0]+" "+meeting[1]);
                groups.union(meeting[0],meeting[1]);
                people.add(meeting[0]);
                people.add(meeting[1]);
            }
            
            for(int p:people){
                if(groups.find(0)==groups.find(p)){
                    peopleWithSecret.add(p);
                }else{
                    groups.disconnect(p);
                }
            }
        }
        return new ArrayList<>(peopleWithSecret);
    }
}