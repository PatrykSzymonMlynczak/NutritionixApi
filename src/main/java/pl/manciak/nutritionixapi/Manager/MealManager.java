package pl.manciak.nutritionixapi.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.nutritionixapi.Service.MealService;
import pl.manciak.nutritionixapi.Service.ProductService;
import pl.manciak.nutritionixapi.dto.NutriResponse.Food;
import pl.manciak.nutritionixapi.entity.Meal;
import pl.manciak.nutritionixapi.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealManager {

    MealService mealService;
    ProductService productService;

    @Autowired
    public MealManager(MealService mealService, ProductService productService)
    {
        this.mealService = mealService;
        this.productService = productService;
    }

    public Meal saveMeal(List<Food> foodList, String mealName){

        Meal newMeal = new Meal();
        newMeal.setMealName(mealName);

        List<Product> productList = parseFoodToProduct(foodList);

        productList.stream().forEach(y -> newMeal.getFoodList().add(y));

        for(Product food : productList) {

            newMeal.setNfCalories(newMeal.getNfCalories() + food.getNfCalories());
            newMeal.setNfCholesterol(newMeal.getNfCholesterol() + food.getNfCholesterol());
            newMeal.setNfDietaryFiber(newMeal.getNfDietaryFiber() + food.getNfDietaryFiber());
            newMeal.setNfP(newMeal.getNfP() + food.getNfP());
            newMeal.setNfPotassium(newMeal.getNfPotassium() + food.getNfPotassium());
            newMeal.setNfProtein(newMeal.getNfProtein() + food.getNfProtein());
            newMeal.setNfSaturatedFat(newMeal.getNfSaturatedFat() + food.getNfSaturatedFat());
            newMeal.setNfSodium(newMeal.getNfSodium() + food.getNfSodium());
            newMeal.setNfSugars(newMeal.getNfSugars() + food.getNfSugars());
            newMeal.setNfTotalCarbohydrate(newMeal.getNfTotalCarbohydrate() + food.getNfTotalCarbohydrate());
            newMeal.setNfTotalFat(newMeal.getNfTotalFat() + food.getNfTotalFat());
            newMeal.setServingWeightGrams(newMeal.getServingWeightGrams() + food.getServingWeightGrams());

           /*if(! productService.ifExists(food.getFoodName())) */
            productService.save(food);
        }

        return mealService.save(newMeal);
    }

    public List<Product> parseFoodToProduct(List<Food> foodList){
        List<Product> productList = new ArrayList<>();

        for(Food food : foodList) {

            Product product = new Product(food.getFoodName(),
                    food.getServingQty(),food.getServingUnit(),
                    food.getServingWeightGrams(),food.getNfCalories(),
                    food.getNfTotalFat(),food.getNfSaturatedFat(),
                    food.getNfCholesterol(),food.getNfSodium(),
                    food.getNfTotalCarbohydrate(),food.getNfDietaryFiber(),
                    food.getNfSugars(),food.getNfProtein(),
                    food.getNfPotassium(),food.getNfP()
            );

            productList.add(product);
        }

            return productList;
    }

    public Meal getMeal(String name){
        if (mealService.findByName(name).isPresent())
            return mealService.findByName(name).get();
        return null;
    }

    public List<Meal> getByFood(List<Product> name){
        return mealService.getByFood(name);
    }


    public void deleteMeal(String mealName){
        mealService.deleteByName(mealName);
    }
}
