package Steps;

import Constants.Constants;
import Models.SearchByIdOrTitleModel;
import Services.SearchByIdOrTitleService;
import Services.SearchByService;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertEquals;

public class SearchByImdSteps {
    String imdbId;
    String title;
    SearchByIdOrTitleService searchByIdOrTitleService = new SearchByIdOrTitleService();
    SearchByService searchByService = new SearchByService();
    SearchByIdOrTitleModel model = new SearchByIdOrTitleModel();


    @Given("^\"([^\"]*)\" değeri ile searchBy isteği oluşturulur$")
    public void createRequest(String titleFromBdd) throws Throwable {
        title = titleFromBdd;
    }

    @When("^SearchByImdb servisine istek gönderilir$")
    public void sendRequestToSearchByService() {
        imdbId = searchByService.searchByGetImdbId(title);
        model = searchByIdOrTitleService.searchByImdbId(imdbId);
    }

    @Then("^Title alanının \"([^\"]*)\" olduğu görülür$")
    public void assertTitle(String expectedTitle) throws Throwable {
        assertEquals(model.getTitle(), Constants.EXPECTED_TITLE);
    }

    @Then("^Year alanının \"([^\"]*)\" olduğu görülür$")
    public void assertYear(String expectedYear) throws Throwable {
        assertEquals(model.getYear(), Constants.EXPECTED_YEAR);
    }

    @Then("^Released alanının \"([^\"]*)\" olduğu görülür$")
    public void assertReleased(String expectedReleased) throws Throwable {
        assertEquals(model.getReleased(), Constants.EXPECTED_RELEASED);;
    }

    @Then("^ImdbTitle alanının \"([^\"]*)\" olduğu görülür$")
    public void assertImdbId(String expectedImdbId) throws Throwable {
        assertEquals(imdbId,expectedImdbId);
    }
}
