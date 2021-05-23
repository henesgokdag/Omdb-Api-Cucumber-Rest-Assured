package Models;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "Title",
        "Year",
        "imdbId",
        "Type",
        "Poster"
})
public class SearchByModel {
    @JsonProperty("Title")
    String title;

    @JsonProperty("Year")
    String year;

    @JsonProperty("imdbID")
    String imdbId;

    @JsonProperty("Type")
    String type;

    @JsonProperty("Poster")
    String poster;



    @JsonProperty("imdbID")
    public String getImdbId() {
        if(imdbId!=null){

            return imdbId;
        }
        else return "";
    }

    @JsonProperty("Poster")
    public String getPoster() {
        return poster;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Year")
    public String getYear() {
        return year;
    }

    @JsonProperty("Type")
    public String getType(){
        return type;
    }
}
