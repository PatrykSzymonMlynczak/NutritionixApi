package pl.manciak.nutritionixapi.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.nutritionixapi.Service.MealService;
import pl.manciak.nutritionixapi.dto.NutriResponse.Food;
import pl.manciak.nutritionixapi.entity.Meal;
import pl.manciak.nutritionixapi.entity.Nutrients;

import java.util.List;

@Service
public class MealManager {

    MealService mealService;

    @Autowired
    public MealManager(MealService mealService) {
        this.mealService = mealService;
    }

    public Meal saveMeal(List<Food> foodList, String mealName){

        Meal newMeal = new Meal();
        newMeal.setMealName(mealName);

        foodList.stream().forEach(y -> newMeal.getFoodList().add(y));

        for(Food food : foodList) {
            Nutrients nutrients = new Nutrients();


            Integer counter = 1;
            do {

                    nutrients.setNfCalories(nutrients.getNfCalories() + food.getNfCalories());
                    nutrients.setNfCholesterol(nutrients.getNfCholesterol() + food.getNfCholesterol());
                    nutrients.setNfDietaryFiber(nutrients.getNfDietaryFiber() + food.getNfDietaryFiber());
                    nutrients.setNfP(nutrients.getNfP() + food.getNfP());
                    nutrients.setNfPotassium(nutrients.getNfPotassium() + food.getNfPotassium());
                    nutrients.setNfProtein(nutrients.getNfProtein() + food.getNfProtein());
                    nutrients.setNfSaturatedFat(nutrients.getNfSaturatedFat() + food.getNfSaturatedFat());
                    nutrients.setNfSodium(nutrients.getNfSodium() + food.getNfSodium());
                    nutrients.setNfSugars(nutrients.getNfSugars() + food.getNfSugars());
                    nutrients.setNfTotalCarbohydrate(nutrients.getNfTotalCarbohydrate() + food.getNfTotalCarbohydrate());
                    nutrients.setNfTotalFat(nutrients.getNfTotalFat() + food.getNfTotalFat());

                counter++;

            } while(food.getServingQty() > counter && food.getServingQty() != food.getServingWeightGrams());

            nutrients.setServingQty(food.getServingQty());
            nutrients.setServingWeightGrams(food.getServingWeightGrams());

            newMeal.setNutrientsSum(nutrients);
        }

        newMeal.getFoodList();
        newMeal.getNutrientsSum();

        mealService.save(newMeal);

        return newMeal;
    }
}
