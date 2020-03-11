
package pl.manciak.nutritionixapi.dto.NutriResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "foods"
})
public class NutritionixResponse {

    @JsonProperty("foods")
    private List<Food> foods = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NutritionixResponse() {
    }

    /**
     * 
     * @param foods
     */
    public NutritionixResponse(List<Food> foods) {
        super();
        this.foods = foods;
    }

    @JsonProperty("foods")
    public List<Food> getFoods() {
        return foods;
    }

    @JsonProperty("foods")
    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
