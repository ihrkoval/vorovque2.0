
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
    "is_golden",
    "deleted",
    "gender",
    "is_ignored",
    "rank",
    "avatar_url",
    "karma",
    "active",
    "login",
    "rank_color",
    "id"
})
public class User {

    @JsonProperty("is_golden")
    private Boolean isGolden;
    @JsonProperty("deleted")
    private Boolean deleted;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("is_ignored")
    private Boolean isIgnored;
    @JsonProperty("rank")
    private String rank;
    @JsonProperty("avatar_url")
    private Object avatarUrl;
    @JsonProperty("karma")
    private Integer karma;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("login")
    private String login;
    @JsonProperty("rank_color")
    private Object rankColor;
    @JsonProperty("id")
    private Integer id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("is_golden")
    public Boolean getIsGolden() {
        return isGolden;
    }

    @JsonProperty("is_golden")
    public void setIsGolden(Boolean isGolden) {
        this.isGolden = isGolden;
    }

    @JsonProperty("deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    @JsonProperty("deleted")
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("is_ignored")
    public Boolean getIsIgnored() {
        return isIgnored;
    }

    @JsonProperty("is_ignored")
    public void setIsIgnored(Boolean isIgnored) {
        this.isIgnored = isIgnored;
    }

    @JsonProperty("rank")
    public String getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(String rank) {
        this.rank = rank;
    }

    @JsonProperty("avatar_url")
    public Object getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("avatar_url")
    public void setAvatarUrl(Object avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @JsonProperty("karma")
    public Integer getKarma() {
        return karma;
    }

    @JsonProperty("karma")
    public void setKarma(Integer karma) {
        this.karma = karma;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    @JsonProperty("rank_color")
    public Object getRankColor() {
        return rankColor;
    }

    @JsonProperty("rank_color")
    public void setRankColor(Object rankColor) {
        this.rankColor = rankColor;
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
