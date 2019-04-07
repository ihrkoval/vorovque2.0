
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
    "irony_color",
    "links_system_color",
    "background_color",
    "header_color",
    "text_color"
})
public class ColorSchema {

    @JsonProperty("irony_color")
    private String ironyColor;
    @JsonProperty("links_system_color")
    private String linksSystemColor;
    @JsonProperty("background_color")
    private String backgroundColor;
    @JsonProperty("header_color")
    private String headerColor;
    @JsonProperty("text_color")
    private String textColor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("irony_color")
    public String getIronyColor() {
        return ironyColor;
    }

    @JsonProperty("irony_color")
    public void setIronyColor(String ironyColor) {
        this.ironyColor = ironyColor;
    }

    @JsonProperty("links_system_color")
    public String getLinksSystemColor() {
        return linksSystemColor;
    }

    @JsonProperty("links_system_color")
    public void setLinksSystemColor(String linksSystemColor) {
        this.linksSystemColor = linksSystemColor;
    }

    @JsonProperty("background_color")
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @JsonProperty("background_color")
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @JsonProperty("header_color")
    public String getHeaderColor() {
        return headerColor;
    }

    @JsonProperty("header_color")
    public void setHeaderColor(String headerColor) {
        this.headerColor = headerColor;
    }

    @JsonProperty("text_color")
    public String getTextColor() {
        return textColor;
    }

    @JsonProperty("text_color")
    public void setTextColor(String textColor) {
        this.textColor = textColor;
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
