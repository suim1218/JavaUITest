package uitest.cases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uitest.config.TestConfig;
import uitest.pages.SearchPage;

public class SearchTest {
    final static Logger Log = Logger.getLogger(String.valueOf(SearchTest.class));

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "D:\\tools\\chromedriver.exe");
        TestConfig.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        TestConfig.driver.quit();
    }


    @Test(dataProvider = "search")
    public void SearchCase(String search, String result) throws Exception {

        TestConfig.driver.get(TestConfig.baseUrl + "/");
        SearchPage.input(TestConfig.driver, search);
        SearchPage.button(TestConfig.driver);
        Thread.sleep(2000);
        String title = TestConfig.driver.getTitle();
        Log.info("参数是：【" + search + "   " + result + "】");
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

