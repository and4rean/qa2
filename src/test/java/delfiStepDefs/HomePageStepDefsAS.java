package delfiStepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class HomePageStepDefsAS {

/*
    @Before
    //basefunctions baseFunc = new
*/
    @Given("Print test anotation (.*)")
    public void print_test_annotation(String annotation) {
        System.out.println(annotation);
    }

    @Given("the weather is (.*) with a temperature ([0-9*])")
    public void weather_data_is(String weather, BigDecimal temperature) {
    }

    @Given("Client attributes are:")
    public void client_attributes_are(Map<String, String> params){
    }

    @When("Sending data to server (.*)")
    public void sending_data_to_server() {
    }

    @Then("Temperature are:")
    public void check_temperatures(List<BigDecimal> temperatures){
    }

/*
    @After("Quit driver")
    public void quit_driver(List<BigDecimal> temperatures){
        //driver quit..
    }
*/

}
