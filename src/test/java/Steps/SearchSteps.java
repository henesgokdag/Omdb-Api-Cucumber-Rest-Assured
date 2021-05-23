package Steps;

import Models.SearchByModel;
import Services.SearchByService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SearchSteps {

    SearchByService searchByService = new SearchByService();
    String searchTitle;
    String title;
    @Given("^\"([^\"]*)\" değeri ile istek oluşturulur$")
    public void createRequest(String searchTitleFromBdd) throws Throwable {
       searchTitle=searchTitleFromBdd;
    }

    @When("^Search servisine istek gönderilir$")
    public void sendRequestToSearchService() {
        List<SearchByModel> searchByModelList = searchByService.searchBy(searchTitle);
        title= searchByService.CheckAndReturnTitle(searchByModelList);
    }

    @Then("^Title değerinin \"([^\"]*)\" olduğu görülür$")
    public void assertTitle(String expectedTitle) throws Throwable {
       assertEquals(title, expectedTitle);
    }


}
