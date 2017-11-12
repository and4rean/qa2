package delfiStepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.math.BigDecimal;

public class WeatherStepDefs {

    private String cityName;

    @Given("City name is (.*)")
    public void setCityName(String name) {
        cityName = name;
    }

    @When("Requesting weather information")
    public void requestWeatherInformation() {
    }

    @Then("Coordinates are lon: (.*) and lat: (.*)")
    public void checkCoordinates(BigDecimal lon, BigDecimal lat)  throws Throwable {
    }


}


