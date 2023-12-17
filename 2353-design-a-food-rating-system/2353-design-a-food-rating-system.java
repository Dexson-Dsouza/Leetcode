class foodRatingPair{
    String food;
    int rating;
    foodRatingPair(String food, int rating){
        this.food=food;
        this.rating=rating;
    }
}

class FoodRatings {
    Map<String,Integer> foodRating;
    Map<String,String> cuisineMap;
    Map<String,PriorityQueue<foodRatingPair>> cuisinesFoodRating;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int inputLen=foods.length;
        foodRating=new HashMap<>();
        cuisineMap=new HashMap<>();
        cuisinesFoodRating=new HashMap<>();
        
        
        for(int food=0;food<inputLen;food++){
            String foodName=foods[food];
            String cusineName=cuisines[food];
            int rating=ratings[food];
            foodRatingPair curPair= new foodRatingPair(foodName,rating);
            foodRating.put(foodName,rating);
            cuisineMap.put(foodName,cusineName);
            if(cuisinesFoodRating.containsKey(cusineName)==false){
                cuisinesFoodRating.put(cusineName,new PriorityQueue<foodRatingPair>((a,b)->b.rating==a.rating?
                                                                         a.food.compareTo(b.food) : b.rating-a.rating));
            }
            cuisinesFoodRating.get(cusineName).add(curPair);
            
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodRating.put(food,newRating);
        String cusineName=cuisineMap.get(food);
        cuisinesFoodRating.get(cusineName).add(new foodRatingPair(food,newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<foodRatingPair> cusineFoodRating=cuisinesFoodRating.get(cuisine);
        while(true){
            foodRatingPair topRatingPair=cusineFoodRating.peek();
            if(topRatingPair.rating != foodRating.get(topRatingPair.food)){
                cusineFoodRating.poll();
            }else{
                break;
            }
        }   
        return cusineFoodRating.peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */