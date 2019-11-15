package uitest.cases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uitest.config.TestConfig;
import uitest.pages.SearchPage;
import uitest.pages.SearchPage2;
import uitest.utils.BrowserEmulator;
import uitest.utils.knifeException;


import static org.testng.Assert.assertEquals;

public class SearchTest2 {
    final static Logger Log = Logger.getLogger(String.valueOf(SearchTest2.class));
    BrowserEmulator driver;
    String baseUrl;

    @BeforeTest
    public void setUp() throws knifeException {

        System.setProperty("webdriver.chrome.driver", "D:\\tools\\chromedriver.exe");
        baseUrl = TestConfig.baseUrl + "/";
        driver = new BrowserEmulator();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    @Test(dataProvider = "search")
    public void SearchCase(String search, String result) throws Exception {
        driver.open(baseUrl);
        SearchPage2.inputs(driver, search);
        SearchPage2.button(driver);
        Thread.sleep(1000);
        Log.info("参数是：【" + search + "   " + result + "】");
        String title = driver.getTitle();
        assertEquals(title, result);
    }

    // 定义对象数组
    @DataProvider(name = "search")
    public Object[][] SearchData() {
        return new Object[][]{
                {"java", "java_百度搜索"},
                {"page object", "page object_百度搜索"},
                {"testNG", "testNG_百度搜索"}
        };
    }
}

