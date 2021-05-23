package Services;

import Constants.Constants;
import Models.SearchByIdOrTitleModel;
import io.restassured.RestAssured;

public class SearchByIdOrTitleService {
    public SearchByIdOrTitleModel searchByImdbId(String imdbTitle) {
        SearchByIdOrTitleModel searchByIdOrTitleModel = RestAssured.given()
                .when()
                .get(Constants.API_URL + "?apikey=" + Constants.API_KEY + "&i=" + imdbTitle)
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getObject("", SearchByIdOrTitleModel.class);
        return searchByIdOrTitleModel;
    }
}
