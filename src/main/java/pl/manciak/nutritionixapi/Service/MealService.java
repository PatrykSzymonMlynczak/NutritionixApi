package pl.manciak.nutritionixapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.nutritionixapi.Repository.MealRepository;
import pl.manciak.nutritionixapi.entity.Meal;

import java.util.List;
import java.util.Optional;

@Service
public class MealService   {

    MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public Optional<Meal> findByName(String name){ return mealRepository.findByMealName(name);}

    public Iterable<Meal> findAll(){return mealRepository.findAll();}

    public void deleteById(Long id){
        mealRepository.deleteById(id);
    }

    public void deleteByName(String name){
        mealRepository.deleteByMealName(name);
    }

    public Meal save (Meal meal){
        return mealRepository.save(meal);
    }

    public List<Meal> getByFood(String products){
       return mealRepository.findMealsBySingularFoodIn(products);

    }



}
