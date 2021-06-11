
package pl.manciak.nutritionixapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonBackReference
    @ManyToMany(mappedBy = "foodList")
    private Set<Meal> meals = new HashSet<>();


    @Column(unique = false, nullable = false)
    private String foodName;

    private Integer servingQty;
    private String servingUnit;
    private Integer servingWeightGrams;
    private Double nfCalories;
    private Double nfTotalFat;
    private Double nfSaturatedFat;
    private Integer nfCholesterol;
    private Integer nfSodium;
    private Double nfTotalCarbohydrate;
    private Integer nfDietaryFiber;
    private Double nfSugars;
    private Double nfProtein;
    private Integer nfPotassium;
    private Integer nfP;



    public Product() {
    }

    public Product(String foodName, Integer servingQty, String servingUnit, Integer servingWeightGrams, Double nfCalories, Double nfTotalFat, Double nfSaturatedFat, Integer nfCholesterol, Integer nfSodium, Double nfTotalCarbohydrate, Integer nfDietaryFiber, Double nfSugars, Double nfProtein, Integer nfPotassium, Integer nfP) {
        this.foodName = foodName;
        this.servingQty = servingQty;
        this.servingUnit = servingUnit;
        this.servingWeightGrams = servingWeightGrams;
        this.nfCalories = nfCalories;
        this.nfTotalFat = nfTotalFat;
        this.nfSaturatedFat = nfSaturatedFat;
        this.nfCholesterol = nfCholesterol;
        this.nfSodium = nfSodium;
        this.nfTotalCarbohydrate = nfTotalCarbohydrate;
        this.nfDietaryFiber = nfDietaryFiber;
        this.nfSugars = nfSugars;
        this.nfProtein = nfProtein;
        this.nfPotassium = nfPotassium;
        this.nfP = nfP;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getServingQty() {
        return servingQty;
    }

    public void setServingQty(Integer servingQty) {
        this.servingQty = servingQty;
    }

    public String getServingUnit() {
        return servingUnit;
    }

    public void setServingUnit(String servingUnit) {
        this.servingUnit = servingUnit;
    }

    public Integer getServingWeightGrams() {
        return servingWeightGrams;
    }

    public void setServingWeightGrams(Integer servingWeightGrams) {
        this.servingWeightGrams = servingWeightGrams;
    }

    public Double getNfCalories() {
        return nfCalories;
    }

    public void setNfCalories(Double nfCalories) {
        this.nfCalories = nfCalories;
    }

    public Double getNfTotalFat() {
        return nfTotalFat;
    }

    public void setNfTotalFat(Double nfTotalFat) {
        this.nfTotalFat = nfTotalFat;
    }

    public Double getNfSaturatedFat() {
        return nfSaturatedFat;
    }

    public void setNfSaturatedFat(Double nfSaturatedFat) {
        this.nfSaturatedFat = nfSaturatedFat;
    }

    public Integer getNfCholesterol() {
        return nfCholesterol;
    }

    public void setNfCholesterol(Integer nfCholesterol) {
        this.nfCholesterol = nfCholesterol;
    }

    public Integer getNfSodium() {
        return nfSodium;
    }

    public void setNfSodium(Integer nfSodium) {
        this.nfSodium = nfSodium;
    }

    public Double getNfTotalCarbohydrate() {
        return nfTotalCarbohydrate;
    }

    public void setNfTotalCarbohydrate(Double nfTotalCarbohydrate) {
        this.nfTotalCarbohydrate = nfTotalCarbohydrate;
    }

    public Integer getNfDietaryFiber() {
        return nfDietaryFiber;
    }

    public void setNfDietaryFiber(Integer nfDietaryFiber) {
        this.nfDietaryFiber = nfDietaryFiber;
    }

    public Double getNfSugars() {
        return nfSugars;
    }

    public void setNfSugars(Double nfSugars) {
        this.nfSugars = nfSugars;
    }

    public Double getNfProtein() {
        return nfProtein;
    }

    public void setNfProtein(Double nfProtein) {
        this.nfProtein = nfProtein;
    }

    public Integer getNfPotassium() {
        return nfPotassium;
    }

    public void setNfPotassium(Integer nfPotassium) {
        this.nfPotassium = nfPotassium;
    }

    public Integer getNfP() {
        return nfP;
    }

    public void setNfP(Integer nfP) {
        this.nfP = nfP;
    }


}
