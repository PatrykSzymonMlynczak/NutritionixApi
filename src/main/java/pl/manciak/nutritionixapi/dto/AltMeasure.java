
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
    "serving_weight",
    "measure",
    "seq",
    "qty"
})
public class AltMeasure {

    @JsonProperty("serving_weight")
    private Double servingWeight;
    @JsonProperty("measure")
    private String measure;
    @JsonProperty("seq")
    private Object seq;
    @JsonProperty("qty")
    private Integer qty;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AltMeasure() {
    }

    /**
     * 
     * @param measure
     * @param qty
     * @param servingWeight
     * @param seq
     */
    public AltMeasure(Double servingWeight, String measure, Object seq, Integer qty) {
        super();
        this.servingWeight = servingWeight;
        this.measure = measure;
        this.seq = seq;
        this.qty = qty;
    }

    @JsonProperty("serving_weight")
    public Double getServingWeight() {
        return servingWeight;
    }

    @JsonProperty("serving_weight")
    public void setServingWeight(Double servingWeight) {
        this.servingWeight = servingWeight;
    }

    @JsonProperty("measure")
    public String getMeasure() {
        return measure;
    }

    @JsonProperty("measure")
    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @JsonProperty("seq")
    public Object getSeq() {
        return seq;
    }

    @JsonProperty("seq")
    public void setSeq(Object seq) {
        this.seq = seq;
    }

    @JsonProperty("qty")
    public Integer getQty() {
        return qty;
    }

    @JsonProperty("qty")
    public void setQty(Integer qty) {
        this.qty = qty;
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
