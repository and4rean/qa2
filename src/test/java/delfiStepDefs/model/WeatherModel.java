package delfiStepDefs.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//if model not fully used - so we need "IgnoreProperties"
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherModel {

    private Coordinates coord;
    //private Weather weather;
    private String base;
    private String visibility;
    private Wind wind;
    private Clouds clouds;

    private Integer dt;
    private Integer id;
    private String name;
    private Integer cod;





    public Coordinates getCoord() {
        return coord;
    }
    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

/*
    public Weather getWeather() {
        return weather;
    }
    public void setWeather(Weather weather) { this.weather = weather; }
*/

    public String getBase() {
        return base;
    }
    public void setBase(String base) {
        this.base = base;
    }


    public String getVisibility() {
        return visibility;
    }
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }


    public Wind getWind() {
        return wind;
    }
    public void setWind(Wind wind) {
        this.wind = wind;
    }


    public Clouds getClouds() {
        return clouds;
    }
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }


    public Integer getDt() {
        return dt;
    }
    public void setDt(Integer dt) {
        this.dt = dt;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public Integer getCod() {
        return cod;
    }
    public void setCod(Integer cod) {
        this.cod = cod;
    }


}
