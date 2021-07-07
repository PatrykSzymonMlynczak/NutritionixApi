package pl.manciak.nutritionixapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.manciak.nutritionixapi.entity.Meal;
import pl.manciak.nutritionixapi.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    void deleteByMealName(String mealName);
    Optional<Meal> findByMealName(String name);

    @Query(
            value = "SELECT * from meal " +
                    "join meal_food_list " +
                    "on meal_food_list.meals_id = meal.id " +
                    "where meal_food_list.food_list_food_name = ?1",
            nativeQuery = true)
    List<Meal> findMealsBySingularFoodIn(String product);

}
