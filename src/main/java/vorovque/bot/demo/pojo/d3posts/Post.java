
package vorovque.bot.demo.pojo.d3posts;

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
    "rating",
    "domain",
    "unread_comments_count",
    "country_code",
    "in_favourites",
    "title",
    "data",
    "golden",
    "id",
    "pinned",
    "user_vote",
    "can_ban",
    "_links",
    "url_slug",
    "tags",
    "main_image_url",
    "can_moderate",
    "hidden_rating_time_to_show",
    "user",
    "can_delete",
    "estimate",
    "can_unpublish",
    "can_change_render_type",
    "can_edit",
    "favourites_count",
    "in_interests",
    "created",
    "changed",
    "vote_weight",
    "comments_count",
    "advertising",
    "has_subscribed"
})
public class Post {

    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("domain")
    private Domain domain;
    @JsonProperty("unread_comments_count")
    private Integer unreadCommentsCount;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("in_favourites")
    private Boolean inFavourites;
    @JsonProperty("title")
    private String title;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("golden")
    private Boolean golden;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("pinned")
    private Boolean pinned;
    @JsonProperty("user_vote")
    private Object userVote;
    @JsonProperty("can_ban")
    private Boolean canBan;
    @JsonProperty("_links")
    private List<Link_> links = null;
    @JsonProperty("url_slug")
    private String urlSlug;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("main_image_url")
    private String mainImageUrl;
    @JsonProperty("can_moderate")
    private Boolean canModerate;
    @JsonProperty("hidden_rating_time_to_show")
    private Object hiddenRatingTimeToShow;
    @JsonProperty("user")
    private User user;
    @JsonProperty("can_delete")
    private Boolean canDelete;
    @JsonProperty("estimate")
    private Integer estimate;
    @JsonProperty("can_unpublish")
    private Boolean canUnpublish;
    @JsonProperty("can_change_render_type")
    private Boolean canChangeRenderType;
    @JsonProperty("can_edit")
    private Boolean canEdit;
    @JsonProperty("favourites_count")
    private Integer favouritesCount;
    @JsonProperty("in_interests")
    private Boolean inInterests;
    @JsonProperty("created")
    private Integer created;
    @JsonProperty("changed")
    private Object changed;
    @JsonProperty("vote_weight")
    private Integer voteWeight;
    @JsonProperty("comments_count")
    private Integer commentsCount;
    @JsonProperty("advertising")
    private Object advertising;
    @JsonProperty("has_subscribed")
    private Boolean hasSubscribed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rating")
    public Integer getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @JsonProperty("domain")
    public Domain getDomain() {
        return domain;
    }

    @JsonProperty("domain")
    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    @JsonProperty("unread_comments_count")
    public Integer getUnreadCommentsCount() {
        return unreadCommentsCount;
    }

    @JsonProperty("unread_comments_count")
    public void setUnreadCommentsCount(Integer unreadCommentsCount) {
        this.unreadCommentsCount = unreadCommentsCount;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("in_favourites")
    public Boolean getInFavourites() {
        return inFavourites;
    }

    @JsonProperty("in_favourites")
    public void setInFavourites(Boolean inFavourites) {
        this.inFavourites = inFavourites;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    @JsonProperty("golden")
    public Boolean getGolden() {
        return golden;
    }

    @JsonProperty("golden")
    public void setGolden(Boolean golden) {
        this.golden = golden;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("pinned")
    public Boolean getPinned() {
        return pinned;
    }

    @JsonProperty("pinned")
    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    @JsonProperty("user_vote")
    public Object getUserVote() {
        return userVote;
    }

    @JsonProperty("user_vote")
    public void setUserVote(Object userVote) {
        this.userVote = userVote;
    }

    @JsonProperty("can_ban")
    public Boolean getCanBan() {
        return canBan;
    }

    @JsonProperty("can_ban")
    public void setCanBan(Boolean canBan) {
        this.canBan = canBan;
    }

    @JsonProperty("_links")
    public List<Link_> getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(List<Link_> links) {
        this.links = links;
    }

    @JsonProperty("url_slug")
    public String getUrlSlug() {
        return urlSlug;
    }

    @JsonProperty("url_slug")
    public void setUrlSlug(String urlSlug) {
        this.urlSlug = urlSlug;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("main_image_url")
    public String getMainImageUrl() {
        return mainImageUrl;
    }

    @JsonProperty("main_image_url")
    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }

    @JsonProperty("can_moderate")
    public Boolean getCanModerate() {
        return canModerate;
    }

    @JsonProperty("can_moderate")
    public void setCanModerate(Boolean canModerate) {
        this.canModerate = canModerate;
    }

    @JsonProperty("hidden_rating_time_to_show")
    public Object getHiddenRatingTimeToShow() {
        return hiddenRatingTimeToShow;
    }

    @JsonProperty("hidden_rating_time_to_show")
    public void setHiddenRatingTimeToShow(Object hiddenRatingTimeToShow) {
        this.hiddenRatingTimeToShow = hiddenRatingTimeToShow;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("can_delete")
    public Boolean getCanDelete() {
        return canDelete;
    }

    @JsonProperty("can_delete")
    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    @JsonProperty("estimate")
    public Integer getEstimate() {
        return estimate;
    }

    @JsonProperty("estimate")
    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }

    @JsonProperty("can_unpublish")
    public Boolean getCanUnpublish() {
        return canUnpublish;
    }

    @JsonProperty("can_unpublish")
    public void setCanUnpublish(Boolean canUnpublish) {
        this.canUnpublish = canUnpublish;
    }

    @JsonProperty("can_change_render_type")
    public Boolean getCanChangeRenderType() {
        return canChangeRenderType;
    }

    @JsonProperty("can_change_render_type")
    public void setCanChangeRenderType(Boolean canChangeRenderType) {
        this.canChangeRenderType = canChangeRenderType;
    }

    @JsonProperty("can_edit")
    public Boolean getCanEdit() {
        return canEdit;
    }

    @JsonProperty("can_edit")
    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    @JsonProperty("favourites_count")
    public Integer getFavouritesCount() {
        return favouritesCount;
    }

    @JsonProperty("favourites_count")
    public void setFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    @JsonProperty("in_interests")
    public Boolean getInInterests() {
        return inInterests;
    }

    @JsonProperty("in_interests")
    public void setInInterests(Boolean inInterests) {
        this.inInterests = inInterests;
    }

    @JsonProperty("created")
    public Integer getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Integer created) {
        this.created = created;
    }

    @JsonProperty("changed")
    public Object getChanged() {
        return changed;
    }

    @JsonProperty("changed")
    public void setChanged(Object changed) {
        this.changed = changed;
    }

    @JsonProperty("vote_weight")
    public Integer getVoteWeight() {
        return voteWeight;
    }

    @JsonProperty("vote_weight")
    public void setVoteWeight(Integer voteWeight) {
        this.voteWeight = voteWeight;
    }

    @JsonProperty("comments_count")
    public Integer getCommentsCount() {
        return commentsCount;
    }

    @JsonProperty("comments_count")
    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    @JsonProperty("advertising")
    public Object getAdvertising() {
        return advertising;
    }

    @JsonProperty("advertising")
    public void setAdvertising(Object advertising) {
        this.advertising = advertising;
    }

    @JsonProperty("has_subscribed")
    public Boolean getHasSubscribed() {
        return hasSubscribed;
    }

    @JsonProperty("has_subscribed")
    public void setHasSubscribed(Boolean hasSubscribed) {
        this.hasSubscribed = hasSubscribed;
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
