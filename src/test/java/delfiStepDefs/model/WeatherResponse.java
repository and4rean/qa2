package delfiStepDefs.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//if model not fully used - so we need "IgnoreProperties"
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private Coordinates coord;

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }
}
