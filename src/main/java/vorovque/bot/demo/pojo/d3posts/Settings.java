
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
    "feed_type",
    "threshold_rating",
    "sorting",
    "threshold_date"
})
public class Settings {

    @JsonProperty("feed_type")
    private String feedType;
    @JsonProperty("threshold_rating")
    private String thresholdRating;
    @JsonProperty("sorting")
    private String sorting;
    @JsonProperty("threshold_date")
    private String thresholdDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("feed_type")
    public String getFeedType() {
        return feedType;
    }

    @JsonProperty("feed_type")
    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    @JsonProperty("threshold_rating")
    public String getThresholdRating() {
        return thresholdRating;
    }

    @JsonProperty("threshold_rating")
    public void setThresholdRating(String thresholdRating) {
        this.thresholdRating = thresholdRating;
    }

    @JsonProperty("sorting")
    public String getSorting() {
        return sorting;
    }

    @JsonProperty("sorting")
    public void setSorting(String sorting) {
        this.sorting = sorting;
    }

    @JsonProperty("threshold_date")
    public String getThresholdDate() {
        return thresholdDate;
    }

    @JsonProperty("threshold_date")
    public void setThresholdDate(String thresholdDate) {
        this.thresholdDate = thresholdDate;
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
