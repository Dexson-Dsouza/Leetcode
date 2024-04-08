class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> rightAsteroids = new LinkedList<>();
        List<Integer> remainingAsteroids = new ArrayList<>();
        
        for(int asteroid:asteroids){
            
            if(asteroid>0){
                rightAsteroids.add(asteroid);
            }else{
                int a = Math.abs(asteroid);
                if(rightAsteroids.size()==0){
                    remainingAsteroids.add(asteroid);
                }
                while(rightAsteroids.size()>0){
                    if(a > rightAsteroids.peekLast()){
                        rightAsteroids.pollLast();
                        if(rightAsteroids.size()==0){
                            remainingAsteroids.add(asteroid);
                        }
                    }else if(a == rightAsteroids.peekLast()){
                        rightAsteroids.pollLast();
                        break;
                    }else{
                        break;
                    }
                }
            }
            
        }
        List<Integer> rems = new ArrayList<>();
        while(rightAsteroids.size()>0){
            rems.add(rightAsteroids.pollLast());
        }
        Collections.reverse(rems);
        for(int n:rems){
            remainingAsteroids.add(n);
        }
        int[] rem = new int[remainingAsteroids.size()];
        for(int i = 0; i<remainingAsteroids.size() ;i++){
            rem[i]=remainingAsteroids.get(i);
        }
        return rem;
    }
}