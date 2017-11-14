package delfiStepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import delfiPageObjectTestAS.Pages.BaseFunctions;
import delfiPageObjectTestAS.Pages.HomePage;
import delfiPageObjectTestAS.Pages.HomePageMOB;
import junit.framework.Assert;


public class DelfiMainPageStepDefsAS {

    /*
    BaseFunctions baseFunc    = new BaseFunctions();
    BaseFunctions baseFuncMOB = new BaseFunctions();

    HomePage homePage = new HomePage(baseFunc);
    HomePageMOB homePageMOB = new HomePageMOB(baseFuncMOB);

    private String title = new String();
    private int count;

    private String titleMOB = new String();
    private int countMOB;

    private static final String HOME_PAGE_URL = "http://delfi.lv";
    private static final String MOB_HOME_PAGE_URL = "http://m.delfi.lv";

    private static String SEARCH_NAME; //= "Āboltiņa stāsta par"; //"Zatlers Šlesera sacīto"; //"Šveices policija"; //"Riga vs Riga";


    @Before
    //@Before("Drivers load (.*)")
    public void drivers_load() {
        //baseFunc.goToURL(HOME_PAGE_URL);
        //baseFuncMOB.goToURL(MOB_HOME_PAGE_URL);
    }


    @Given("Given title (.*)")
    public void given_title(String SEARCH_BY) throws Throwable {
        baseFunc.goToURL(HOME_PAGE_URL);
        baseFuncMOB.goToURL(MOB_HOME_PAGE_URL);

        SEARCH_NAME = SEARCH_BY;
    }


    @When("Search for titles and counts")
    public void title_search() throws Throwable {

        title = homePage.getArticleTitleNameAS(SEARCH_NAME);
        System.out.println("title AS: "+title);

        count = homePage.getArticleCommentCountAS(SEARCH_NAME);
        System.out.println("count AS: "+count);

        titleMOB = homePageMOB.getArticleTitleNameAS(SEARCH_NAME);
        System.out.println("MOB title AS: "+titleMOB);

        countMOB = homePageMOB.getArticleCommentCountAS(SEARCH_NAME);
        System.out.println("MOB count AS: "+countMOB);
    }


    @Then("Assert Titles")
    public void assert_titles() throws Throwable  {

        //title = homePage.getArticleTitleNameAS(SEARCH_NAME);
        //titleMOB = homePageMOB.getArticleTitleNameAS(SEARCH_NAME);
        Assert.assertEquals("Not Equal Count and MOB Count", title, titleMOB);
    }


    @Then("Assert Counts is: (.*)")
    public void assert_counts(int givenCount) throws Throwable  {

        //count = homePage.getArticleCommentCountAS(SEARCH_NAME);
        //countMOB = homePageMOB.getArticleCommentCountAS(SEARCH_NAME);

        Assert.assertEquals("Not Equal Count and MOB Count", givenCount, count);
        Assert.assertEquals("Not Equal Count and MOB Count", givenCount, countMOB);

        Assert.assertEquals("Not Equal Count and MOB Count", count, countMOB);
    }



    @After
    //@After("Quiting driver and MOB driver  (.*)")
    public void quit_drivers(){
        baseFunc.quitDriver();
        baseFuncMOB.quitDriver();
    }

    */

}
