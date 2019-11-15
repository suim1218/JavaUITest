package uitest.pages;

import uitest.utils.BrowserEmulator;
import uitest.utils.knifeException;

public class SearchPage2 {

    static String searchBox = "id=>kw";
    static String searchBtn = "id=>su";

    //百度搜索框
    public static void inputs(BrowserEmulator driver, String searchKey) throws knifeException {
        driver.input(searchBox, searchKey);
//        driver.findElement(By.xpath("//*[@id='kw']")).sendKeys(searchKey);
    }

    //百度搜索按钮
    public static void button(BrowserEmulator driver) throws knifeException {
        driver.click(searchBtn);
    }
}

