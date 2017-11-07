package delfiStepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import delfiPageObjectTestAS.Pages.BaseFunctions;
import delfiPageObjectTestAS.Pages.HomePage;
import delfiPageObjectTestAS.Pages.HomePageMOB;


public class DelfiMainPageStepDefsAS {

    BaseFunctions baseFunc    = new BaseFunctions();
    BaseFunctions baseFuncMOB = new BaseFunctions();

    HomePage homePage = new HomePage(baseFunc);
    HomePageMOB homePageMOB = new HomePageMOB(baseFuncMOB);

    String title = new String();
    int count;

    String titleMOB = new String();
    int countMOB;

    private static final String HOME_PAGE_URL = "http://delfi.lv";
    private static final String MOB_HOME_PAGE_URL = "http://m.delfi.lv";
    private static /*final*/ String SEARCH_NAME = "Saūda Arābijā aizturēti"; //"Zatlers Šlesera sacīto"; //"Šveices policija"; //"Riga vs Riga";


    @Before
    //@Before("Drivers load (.*)")
    public void drivers_load() {
        baseFunc.goToURL(HOME_PAGE_URL);
        baseFuncMOB.goToURL(MOB_HOME_PAGE_URL);
    }


    @Given("Give search name")
    public void give_search(String SEARCH_BY) {
        this.SEARCH_NAME = SEARCH_BY;
    }


    @When("Search for Title and CommentCount (.*)")
    public void title_search() {

        title = homePage.getArticleTitleNameAS(SEARCH_NAME);
        System.out.println("title AS: "+title);

        count = homePage.getArticleCommentCountAS(SEARCH_NAME);
        System.out.println("count AS: "+count);

        titleMOB = homePageMOB.getArticleTitleNameAS(SEARCH_NAME);
        System.out.println("MOB title AS: "+titleMOB);

        countMOB = homePageMOB.getArticleCommentCountAS(SEARCH_NAME);
        System.out.println("MOB count AS: "+countMOB);
    }

    @Then("Comparing (Assert) Title and MOB title (.*)")
    public void assertion_title_test(String title, String titleMOB) {

        //Assert.assertEquals("Not Equal title and MOB Title", title, titleMOB);
        //Assert.assertEquals("Not Equal Count and MOB Count", count, countMOB);
    }

    @Then("Comparing (Assert) CommentCount and MOB CommentCount (.*)")
    public void assertion_count_test(int count, int countMOB) {

        //Assert.assertEquals("Not Equal title and MOB Title", title, titleMOB);
        //Assert.assertEquals("Not Equal Count and MOB Count", count, countMOB);
    }



    @After
    //@After("Quiting driver and MOB driver  (.*)")
    public void quit_drivers(){
        baseFunc.quitDriver();
        baseFuncMOB.quitDriver();
    }



}
