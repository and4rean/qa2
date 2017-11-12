package delfiStepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import delfiStepDefs.model.WeatherModel;
import org.junit.Assert;

import java.io.IOException;
import java.math.BigDecimal;

public class WeatherStepDefs {

    private WeatherRequester wReq = new WeatherRequester();
    private String cityName;
    private WeatherModel weaModel = new WeatherModel();

    @Given("City name is (.*)")
    public void setCityName(String name) {
        cityName = name;
    }

    @When("Requesting weather information")
    public void requestWeatherInformation() throws IOException {

        weaModel = wReq.getWeather(cityName);
    }

    @Then("Then coordinate are Lon: (.*) and Lat: (.*)")
    public void checkCoordinates(BigDecimal lon, BigDecimal lat) {
        Assert.assertEquals(lon, weaModel.getCoord().getLon());
        Assert.assertEquals(lat, weaModel.getCoord().getLat());

    }


}


