
package pl.manciak.nutritionixapi.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attr_id",
    "value"
})
public class FullNutrient {

    @JsonProperty("attr_id")
    private Integer attrId;
    @JsonProperty("value")
    private Double value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FullNutrient() {
    }

    /**
     * 
     * @param attrId
     * @param value
     */
    public FullNutrient(Integer attrId, Double value) {
        super();
        this.attrId = attrId;
        this.value = value;
    }

    @JsonProperty("attr_id")
    public Integer getAttrId() {
        return attrId;
    }

    @JsonProperty("attr_id")
    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    @JsonProperty("value")
    public Double getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Double value) {
        this.value = value;
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
