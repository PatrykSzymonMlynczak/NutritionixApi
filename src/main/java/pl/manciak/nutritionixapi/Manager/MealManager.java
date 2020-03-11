package pl.manciak.nutritionixapi.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.nutritionixapi.Service.MealService;
import pl.manciak.nutritionixapi.dto.NutriResponse.Food;
import pl.manciak.nutritionixapi.entity.Meal;

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
        newMeal.getFoodList();

        mealService.save(newMeal);


        return newMeal;
    }
}
