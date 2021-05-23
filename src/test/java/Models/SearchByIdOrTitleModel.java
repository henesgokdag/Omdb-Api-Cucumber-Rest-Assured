package Models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "Title",
        "Year",
        "Released"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchByIdOrTitleModel {

    @JsonProperty("Title")
    String title;

    @JsonProperty("Year")
    String year;

    @JsonProperty("Released")
    String released;

    public String getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getReleased() {
        return released;
    }
}
