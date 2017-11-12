package delfiStepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import delfiStepDefs.model.WeatherResponse;
import org.junit.Assert;

import java.io.IOException;
import java.math.BigDecimal;

public class WeatherStepDefs {

    private WeatherRequester wRequest = new WeatherRequester();
    private String cityName;
    private WeatherResponse wResponse = new WeatherResponse();

    @Given("City name is (.*)")
    public void setCityName(String name) {
        cityName = name;
    }

    @When("Requesting weather information")
    public void requestWeatherInformation() throws IOException {

        wResponse = wRequest.getWeather(cityName);
    }

    @Then("Then coordinate are Lon: (.*) and Lat: (.*)")
    public void checkCoordinates(BigDecimal lon, BigDecimal lat) {
        Assert.assertEquals(lon, wResponse.getCoord().getLon());
        Assert.assertEquals(lat, wResponse.getCoord().getLat());

    }


}


