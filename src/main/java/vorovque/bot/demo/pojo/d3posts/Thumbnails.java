
package vorovque.bot.demo.pojo.d3posts;

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
    "width_120",
    "original",
    "width_500",
    "width_330",
    "width_700"
})
public class Thumbnails {

    @JsonProperty("width_120")
    private Width120 width120;
    @JsonProperty("original")
    private Original original;
    @JsonProperty("width_500")
    private Width500 width500;
    @JsonProperty("width_330")
    private Width330 width330;
    @JsonProperty("width_700")
    private Width700 width700;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("width_120")
    public Width120 getWidth120() {
        return width120;
    }

    @JsonProperty("width_120")
    public void setWidth120(Width120 width120) {
        this.width120 = width120;
    }

    @JsonProperty("original")
    public Original getOriginal() {
        return original;
    }

    @JsonProperty("original")
    public void setOriginal(Original original) {
        this.original = original;
    }

    @JsonProperty("width_500")
    public Width500 getWidth500() {
        return width500;
    }

    @JsonProperty("width_500")
    public void setWidth500(Width500 width500) {
        this.width500 = width500;
    }

    @JsonProperty("width_330")
    public Width330 getWidth330() {
        return width330;
    }

    @JsonProperty("width_330")
    public void setWidth330(Width330 width330) {
        this.width330 = width330;
    }

    @JsonProperty("width_700")
    public Width700 getWidth700() {
        return width700;
    }

    @JsonProperty("width_700")
    public void setWidth700(Width700 width700) {
        this.width700 = width700;
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
