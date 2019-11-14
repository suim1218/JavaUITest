package uitest.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestConfig {

    //登陆接口uri
    public static String baseUrl = "http://www.baidu.com";


    public static WebDriver driver = new ChromeDriver();

    // 数据库配置
    public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static String DB_URL = "jdbc:mysql://localhost:3306/blog";
    public static String USER = "root";
    public static String PASSWORD = "";

}
