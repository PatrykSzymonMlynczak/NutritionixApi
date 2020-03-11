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

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FoodEntity> foodList = new ArrayList<>();

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Nutriensts> nutrienstsSum = new ArrayList<>();

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

    public List<Nutriensts> getNutrienstsSum() {
        return nutrienstsSum;
    }

    public void setNutrienstsSum(List<Nutriensts> nutrienstsSum) {
        this.nutrienstsSum = nutrienstsSum;
    }
}
