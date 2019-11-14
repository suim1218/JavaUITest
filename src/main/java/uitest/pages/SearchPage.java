package uitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    //百度搜索框
    public static void input(WebDriver driver, String searchKey) {
        driver.findElement(By.xpath("//*[@id='kw']")).sendKeys(searchKey);
    }

    //百度搜索按钮
    public static void button(WebDriver driver) {
        driver.findElement(By.id("su")).click();
    }
}

