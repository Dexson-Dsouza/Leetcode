class Solution {
   public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,List<String>> ingredientRecipeMap=new HashMap<>();
        Set<String> recipeSet=new HashSet<>();
        Map<String,Integer> recipeIngredientCount=new HashMap<>();
        for(int i=0;i<recipes.length;i++){
            String recipe=recipes[i];
            recipeSet.add(recipe);
            recipeIngredientCount.put(recipe,ingredients.get(i).size());
            for(int j=0;j<ingredients.get(i).size();j++){
                String ingredient=ingredients.get(i).get(j);
                if(ingredientRecipeMap.containsKey(ingredient)==false){
                    ingredientRecipeMap.put(ingredient,new ArrayList<>());
                }
                ingredientRecipeMap.get(ingredient).add(recipe);
            }
        }        

        Set<String> curSupply=new HashSet<>();
        for(String supply:supplies){
            curSupply.add(supply);
        }

        Set<String> result=new HashSet<>();

        while(curSupply.size()>0){
            Set<String> nextSupply=new HashSet<>();
            for(String supply:curSupply){
                if(ingredientRecipeMap.containsKey(supply)==false){
                    continue;
                }
                for(String recipe:ingredientRecipeMap.get(supply)){
                    recipeIngredientCount.put(recipe,recipeIngredientCount.get(recipe)-1);
                    if(recipeIngredientCount.get(recipe)==0){
                        nextSupply.add(recipe);
                        // if(recipeSet.contains(recipe)){
                            result.add(recipe);
                        // }
                    }
                }
            }
            curSupply=nextSupply;
        }
        return new ArrayList<>(result);
    }	
}