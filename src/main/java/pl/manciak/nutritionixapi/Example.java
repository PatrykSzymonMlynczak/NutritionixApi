package pl.manciak.nutritionixapi;

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
        "query",
        "num_servings",
        "aggregate",
        "line_delimited",
        "use_raw_foods",
        "include_subrecipe",
        "timezone",
        "consumed_at",
        "lat",
        "lng",
        "meal_type",
        "use_branded_foods",
        "locale"
})
public class Example {

    @JsonProperty("query")
    private String query;
    @JsonProperty("num_servings")
    private Integer numServings;
    @JsonProperty("aggregate")
    private String aggregate;
    @JsonProperty("line_delimited")
    private Boolean lineDelimited;
    @JsonProperty("use_raw_foods")
    private Boolean useRawFoods;
    @JsonProperty("include_subrecipe")
    private Boolean includeSubrecipe;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("consumed_at")
    private String consumedAt;
    @JsonProperty("lat")
    private Integer lat;
    @JsonProperty("lng")
    private Integer lng;
    @JsonProperty("meal_type")
    private Integer mealType;
    @JsonProperty("use_branded_foods")
    private Boolean useBrandedFoods;
    @JsonProperty("locale")
    private String locale;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Example() {
    }

    /**
     *
     * @param lineDelimited
     * @param lng
     * @param numServings
     * @param timezone
     * @param query
     * @param mealType
     * @param useRawFoods
     * @param consumedAt
     * @param locale
     * @param useBrandedFoods
     * @param aggregate
     * @param includeSubrecipe
     * @param lat
     */
    public Example(String query, Integer numServings, String aggregate, Boolean lineDelimited, Boolean useRawFoods, Boolean includeSubrecipe, String timezone, String consumedAt, Integer lat, Integer lng, Integer mealType, Boolean useBrandedFoods, String locale) {
        super();
        this.query = query;
        this.numServings = numServings;
        this.aggregate = aggregate;
        this.lineDelimited = lineDelimited;
        this.useRawFoods = useRawFoods;
        this.includeSubrecipe = includeSubrecipe;
        this.timezone = timezone;
        this.consumedAt = consumedAt;
        this.lat = lat;
        this.lng = lng;
        this.mealType = mealType;
        this.useBrandedFoods = useBrandedFoods;
        this.locale = locale;
    }

    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    @JsonProperty("num_servings")
    public Integer getNumServings() {
        return numServings;
    }

    @JsonProperty("num_servings")
    public void setNumServings(Integer numServings) {
        this.numServings = numServings;
    }

    @JsonProperty("aggregate")
    public String getAggregate() {
        return aggregate;
    }

    @JsonProperty("aggregate")
    public void setAggregate(String aggregate) {
        this.aggregate = aggregate;
    }

    @JsonProperty("line_delimited")
    public Boolean getLineDelimited() {
        return lineDelimited;
    }

    @JsonProperty("line_delimited")
    public void setLineDelimited(Boolean lineDelimited) {
        this.lineDelimited = lineDelimited;
    }

    @JsonProperty("use_raw_foods")
    public Boolean getUseRawFoods() {
        return useRawFoods;
    }

    @JsonProperty("use_raw_foods")
    public void setUseRawFoods(Boolean useRawFoods) {
        this.useRawFoods = useRawFoods;
    }

    @JsonProperty("include_subrecipe")
    public Boolean getIncludeSubrecipe() {
        return includeSubrecipe;
    }

    @JsonProperty("include_subrecipe")
    public void setIncludeSubrecipe(Boolean includeSubrecipe) {
        this.includeSubrecipe = includeSubrecipe;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("consumed_at")
    public String getConsumedAt() {
        return consumedAt;
    }

    @JsonProperty("consumed_at")
    public void setConsumedAt(String consumedAt) {
        this.consumedAt = consumedAt;
    }

    @JsonProperty("lat")
    public Integer getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Integer lat) {
        this.lat = lat;
    }

    @JsonProperty("lng")
    public Integer getLng() {
        return lng;
    }

    @JsonProperty("lng")
    public void setLng(Integer lng) {
        this.lng = lng;
    }

    @JsonProperty("meal_type")
    public Integer getMealType() {
        return mealType;
    }

    @JsonProperty("meal_type")
    public void setMealType(Integer mealType) {
        this.mealType = mealType;
    }

    @JsonProperty("use_branded_foods")
    public Boolean getUseBrandedFoods() {
        return useBrandedFoods;
    }

    @JsonProperty("use_branded_foods")
    public void setUseBrandedFoods(Boolean useBrandedFoods) {
        this.useBrandedFoods = useBrandedFoods;
    }

    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
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