Feature: Testing Delfi home-page and home-pageMOB - comparing title name and comment count
  Scenario: First and Only Scenario
    Before drivers_load()
    //Given Search for Title and CommentCount ("Bundesvēra analītiķi")
    //Given give_search("hello world")
    When Search for Title and CommentCount ("Studentiem par")
    //When title_search("Studentiem par")
    After quit_drivers()