package uitest.cases;


import org.testng.annotations.*;
import uitest.utils.BrowserEmulator;
import uitest.utils.knifeException;

import static org.testng.Assert.assertEquals;



/**
 * The demo to show Knife and TestNG basic usage
 * @author bugmaster
 */
public class BaiduDemo {

    BrowserEmulator driver;
    String baseUrl;

    String searchBox = "id=>kw";
    String searchBtn = "id=>su";

    @BeforeMethod
    public void setUp() throws knifeException {
        System.setProperty("webdriver.chrome.driver", "D:\\tools\\chromedriver.exe");
        baseUrl = "https://www.baidu.com";
        driver = new BrowserEmulator();
    }

    // 定义对象数组
    @DataProvider(name = "search")
    public Object[][] Keys() {
        return new Object[][] {
                {"Java"},{"testNG"},{"arrow"},{"Knife"}, };
    }

    @Test(dataProvider = "search")
    public void testSearch(String searchKey) throws InterruptedException {
        driver.open(baseUrl);
        driver.input(searchBox, searchKey);
        driver.click(searchBtn);
        Thread.sleep(2000);
        assertEquals(driver.getTitle(), searchKey+"_百度搜索");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
