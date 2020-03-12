package pl.manciak.nutritionixapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Nutrients {

/*    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    private Integer servingWeightGrams;
    private Integer servingQty;
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


    public Nutrients(){}

/*    public void increeseNutrients(  Integer servingWeightGrams,
             Integer servingQty,
             Double nfCalories,
             Double nfTotalFat,
             Double nfSaturatedFat,
             Integer nfCholesterol,
             Integer nfSodium,
             Double nfTotalCarbohydrate,
             Integer nfDietaryFiber,
             Double nfSugars,
             Double nfProtein,
             Integer nfPotassium,
             Integer nfP){

         this.servingQty += servingQty;
         nfCalories;
         nfTotalFat;
         nfSaturatedFat;
         nfCholesterol;
         nfSodium;
         nfTotalCarbohydrate;
         nfDietaryFiber;
         nfSugars;
         nfProtein;
         nfPotassium;
         nfP;

    }*/



    public Integer getServingWeightGrams() {
        return servingWeightGrams;
    }

    public void setServingWeightGrams(Integer servingWeightGrams) {
        this.servingWeightGrams = servingWeightGrams;
    }

    public Integer getServingQty() {
        return servingQty;
    }

    public void setServingQty(Integer servingQty) {
        this.servingQty = servingQty;
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
