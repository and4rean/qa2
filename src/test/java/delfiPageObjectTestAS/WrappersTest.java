package delfiPageObjectTestAS;

import delfiPageObjectTestAS.Pages.ArticlePage;
import delfiPageObjectTestAS.Pages.BaseFunctions;
import delfiPageObjectTestAS.Pages.HomePage;
import org.openqa.selenium.By;

public class WrappersTest {

    BaseFunctions baseFunc = new BaseFunctions();
    private static final String HOME_PAGE_URL = "http://delfi.lv";
    private static final String ARTICLE_NAME = "Riga vs Riga";


    public void wrapperTest () {
        baseFunc.goToURL(HOME_PAGE_URL);
        HomePage homePage = new HomePage(baseFunc);

        ArticlePage articlePage = homePage.openArticle();
    }

}
