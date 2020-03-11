package pl.manciak.nutritionixapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.manciak.nutritionixapi.entity.Meal;

import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    void deleteByMealName(String mealName);
    Optional<Meal> findByMealName(String name);
}
