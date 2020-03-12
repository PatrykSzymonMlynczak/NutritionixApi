package pl.manciak.nutritionixapi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mealName;

    private Nutrients nutrientsSum;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FoodEntity> foodList = new ArrayList<>();



    public Meal() {
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public List<FoodEntity> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<FoodEntity> foodList) {
        this.foodList = foodList;
    }

    public Nutrients getNutrientsSum() {
        return nutrientsSum;
    }

    public void setNutrientsSum(Nutrients nutrientsSum) {
        this.nutrientsSum = nutrientsSum;
    }
}
