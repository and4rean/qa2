Feature: WheatherTest
  Scenario: Test town coordinates
    Given City name is London
    When Requesting weather information
    Then Coordinate are Lon: -0.13 and Lat: 51.51

    And Weather details are id: 300 and main: Drizzle and description: light intensity drizzle and icon: 09d

    And base is: stations
    And visibility is: 10000
    And Winds details are speed: 4.1 and deg: 80
    And Clouds is all: 90

    And dt is: 1485789600
    And id is: 2643743
    And name is: London
    And cod is: 200



