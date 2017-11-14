package delfiStepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import delfiStepDefs.model.WeatherModel;
import org.junit.Assert;

import java.io.IOException;
import java.math.BigDecimal;

public class WeatherStepDefs {

    //http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1
    private WeatherRequester wReq = new WeatherRequester();
    private String cityName;
    private WeatherModel weaModel = new WeatherModel();

    @Given("City name is (.*)")
    public void setCityName(String name) {
        cityName = name;
    }

    @When("Requesting weather information")
    public void requestWeatherInformation() throws IOException {
        //http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1
        weaModel = wReq.getWeather(cityName);
    }

    @Then("Then coordinate are Lon: (.*) and Lat: (.*)")
    public void checkCoordinates(BigDecimal lon, BigDecimal lat) {
        Assert.assertEquals(lon, weaModel.getCoord().getLon());
        Assert.assertEquals(lat, weaModel.getCoord().getLat());
    }


    @And("Then base is: (.*)")
    public void checkBase(String base) {
        Assert.assertEquals(base, weaModel.getBase());
    }

    @And("Then visibility is: (.*)")
    public void checkVisibility(String visibility) {
        Assert.assertEquals(visibility, weaModel.getVisibility());
    }

    @And("Then winds details are speed: (.*) and deg: (.*)")
    public void checkWind(BigDecimal speed, Integer deg) {
        Assert.assertEquals(speed, weaModel.getWind().getSpeed());
        Assert.assertEquals(deg, weaModel.getWind().getDeg());
    }

    @And("Then clouds is all: (.*)")
    public void checkClouds(Integer all) {
        Assert.assertEquals(all, weaModel.getClouds().getAll());
    }



    @And("Then dt is: (.*)")
    public void checkDt(Integer dt) {
        Assert.assertEquals(dt, weaModel.getDt());
    }

    @And("Then id is: (.*)")
    public void checkId(Integer id) {
        Assert.assertEquals(id, weaModel.getId());
    }

    @And("Then name is: (.*)")
    public void checkDt(String name) {
        Assert.assertEquals(name, weaModel.getName());
    }

    @And("Then cod is: (.*)")
    public void checkCod(Integer cod) {
        Assert.assertEquals(cod, weaModel.getCod());
    }


}


