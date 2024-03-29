package qaf.example.steps;

import java.util.List;
import java.util.Map;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import qaf.example.pages.GooglePage;

@QAFTestStepProvider
public class GoogleStepDefs {

	GooglePage googlePage = new GooglePage();

	@Given("^I am on Google Search Page$")
	public void I_am_on_Google_Search_Page() throws Throwable {
		new WebDriverTestBase().getDriver().get("https://www.google.com/");
	}

	@When("^I search for \"([^\"]*)\"$")
	public void I_search_for(String searchKey) throws Throwable {
		googlePage.search(searchKey);
	}

	@Then("^it should have \"([^\"]*)\" in search results$")
	public void it_should_have_in_search_results(String result) throws Throwable {
		googlePage.verifyResult(result);
	}

	@Then("^it should have following search results:$")
	public void it_should_have_all_in_search_results(List<String> results) {
		googlePage.verifyResult(results);
	}

	@Given("^I have the following books in the store:$")
	public void iHaveTheFollowingBooksInTheStore(List<Map<Object, Object>> dataList) {
		for (Map<Object, Object> dataMap : dataList) {
			for (Map.Entry<Object, Object> entry : dataMap.entrySet()) {
				System.out.println(entry.getKey().toString() + "*************" + entry.getValue().toString());
			}
		}
	}

	@Then("I validate that config type is \"([^\"]*)\" for the item \"([^\"]*)\" in detail view")
	public void i_validate_config_type_in_detail_view(String configType, String itemName) {
		System.out.println("Config type & item name - " + configType + " " + itemName);
	}
}
