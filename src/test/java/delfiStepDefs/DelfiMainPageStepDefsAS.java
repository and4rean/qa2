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

    private static final String SEARCH_NAME = "Āboltiņa stāsta par"; //"Zatlers Šlesera sacīto"; //"Šveices policija"; //"Riga vs Riga";

/*
    @Before
    //@Before("Drivers load (.*)")
    public void drivers_load() {
        baseFunc.goToURL(HOME_PAGE_URL);
        baseFuncMOB.goToURL(MOB_HOME_PAGE_URL);
    }

    @Given("Print testik (.*)")
    public void print_test_annotation(String annotation) {
        System.out.println(annotation);
    }


    @Given("^Search for Title (.*)")
    public void title_search(String SEARCH_BY) throws Throwable {

        //this.SEARCH_NAME = SEARCH_BY;
        //title = homePage.getArticleTitleNameAS("Neapturamais Porziņģis");   //title = homePage.getArticleTitleNameAS(SEARCH_BY);

        title = homePage.getArticleTitleNameAS(SEARCH_NAME);
        System.out.println("title AS: "+title);

        count = homePage.getArticleCommentCountAS(SEARCH_NAME);
        System.out.println("count AS: "+count);

        titleMOB = homePageMOB.getArticleTitleNameAS(SEARCH_NAME);
        System.out.println("MOB title AS: "+titleMOB);

        countMOB = homePageMOB.getArticleCommentCountAS(SEARCH_NAME);
        System.out.println("MOB count AS: "+countMOB);
    }


    @Then("^Assert Titles$")
    public void assert_titles() throws Throwable  {

        title = homePage.getArticleTitleNameAS(SEARCH_NAME);
        titleMOB = homePageMOB.getArticleTitleNameAS(SEARCH_NAME);
        Assert.assertEquals("Not Equal Count and MOB Count", title, titleMOB);
    }


    @Then("^Assert Counts$")
    public void assert_counts() throws Throwable  {

        count = homePage.getArticleCommentCountAS(SEARCH_NAME);
        countMOB = homePageMOB.getArticleCommentCountAS(SEARCH_NAME);
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
