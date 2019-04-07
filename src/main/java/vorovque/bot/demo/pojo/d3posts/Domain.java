
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
    "title",
    "url",
    "readers_count",
    "is_subscribed",
    "is_ignored",
    "color_schema",
    "is_adult",
    "prefix",
    "logo_url",
    "id"
})
public class Domain {

    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonProperty("readers_count")
    private Integer readersCount;
    @JsonProperty("is_subscribed")
    private Boolean isSubscribed;
    @JsonProperty("is_ignored")
    private Boolean isIgnored;
    @JsonProperty("color_schema")
    private ColorSchema colorSchema;
    @JsonProperty("is_adult")
    private Boolean isAdult;
    @JsonProperty("prefix")
    private String prefix;
    @JsonProperty("logo_url")
    private String logoUrl;
    @JsonProperty("id")
    private Integer id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("readers_count")
    public Integer getReadersCount() {
        return readersCount;
    }

    @JsonProperty("readers_count")
    public void setReadersCount(Integer readersCount) {
        this.readersCount = readersCount;
    }

    @JsonProperty("is_subscribed")
    public Boolean getIsSubscribed() {
        return isSubscribed;
    }

    @JsonProperty("is_subscribed")
    public void setIsSubscribed(Boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    @JsonProperty("is_ignored")
    public Boolean getIsIgnored() {
        return isIgnored;
    }

    @JsonProperty("is_ignored")
    public void setIsIgnored(Boolean isIgnored) {
        this.isIgnored = isIgnored;
    }

    @JsonProperty("color_schema")
    public ColorSchema getColorSchema() {
        return colorSchema;
    }

    @JsonProperty("color_schema")
    public void setColorSchema(ColorSchema colorSchema) {
        this.colorSchema = colorSchema;
    }

    @JsonProperty("is_adult")
    public Boolean getIsAdult() {
        return isAdult;
    }

    @JsonProperty("is_adult")
    public void setIsAdult(Boolean isAdult) {
        this.isAdult = isAdult;
    }

    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    @JsonProperty("prefix")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @JsonProperty("logo_url")
    public String getLogoUrl() {
        return logoUrl;
    }

    @JsonProperty("logo_url")
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
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
