package pl.manciak.nutritionixapi.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductId implements Serializable {

    private String foodName;
    private Integer servingQty;
    private String servingUnit;
    private Integer servingWeightGrams;

    public ProductId(){}

    public ProductId(String foodName, Integer servingQty, String servingUnit, Integer servingWeightGrams) {
        this.foodName = foodName;
        this.servingQty = servingQty;
        this.servingUnit = servingUnit;
        this.servingWeightGrams = servingWeightGrams;
    }

    public String getFoodName() {
        return foodName;
    }

    public Integer getServingQty() {
        return servingQty;
    }

    public String getServingUnit() {
        return servingUnit;
    }

    public Integer getServingWeightGrams() {
        return servingWeightGrams;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setServingQty(Integer servingQty) {
        this.servingQty = servingQty;
    }

    public void setServingUnit(String servingUnit) {
        this.servingUnit = servingUnit;
    }

    public void setServingWeightGrams(Integer servingWeightGrams) {
        this.servingWeightGrams = servingWeightGrams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductId)) return false;
        ProductId productId = (ProductId) o;
        return foodName.equals(productId.foodName) && servingQty.equals(productId.servingQty) && servingUnit.equals(productId.servingUnit) && servingWeightGrams.equals(productId.servingWeightGrams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodName, servingQty, servingUnit, servingWeightGrams);
    }
}
