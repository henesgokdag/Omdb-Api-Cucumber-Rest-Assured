package Services;

import Constants.Constants;
import Models.SearchByModel;
import io.restassured.RestAssured;

import java.util.List;

public class SearchByService {
    public List<SearchByModel> searchBy(String movieName) {
        List<SearchByModel> searchByModelList = RestAssured.given()
                .param("apikey",Constants.API_KEY)
                .param("s",movieName)
                .when()
                .get(Constants.API_URL)
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList("Search", SearchByModel.class);
        return searchByModelList;
    }

    public String searchByGetImdbId(String movieName){
        List<SearchByModel> searchByModelList = searchBy(movieName);
        String imdbId=CheckAndReturnImdbId(searchByModelList);
        return  imdbId;
    }

    public String CheckAndReturnImdbId(List<SearchByModel> searchByModelList){
        String imdbId="";
        SearchByModel selectedModel = new SearchByModel();
        for (SearchByModel item :searchByModelList) {
            if(item.getTitle().equals(Constants.EXPECTED_TITLE)){
                selectedModel= item;
                return selectedModel.getImdbId();
            }
        }
        return imdbId;
    }

    public String CheckAndReturnTitle(List<SearchByModel> searchByModelList){
        String title="";
        SearchByModel selectedModel = new SearchByModel();
        for (SearchByModel item :searchByModelList) {
            if(item.getTitle().equals(Constants.EXPECTED_TITLE)){
                selectedModel= item;
                return selectedModel.getTitle();
            }
        }
        return title;
    }

    public SearchByModel CheckAndReturnModel(List<SearchByModel> searchByModelList){
        SearchByModel selectedModel = new SearchByModel();
        for (SearchByModel item :searchByModelList) {
            if(item.getTitle().equals(Constants.EXPECTED_TITLE)){
                selectedModel= item;
            }
        }
        return  selectedModel;
    }
}
