import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage(){
        // String path = "C:\\Users\\olo88\\Desktop\\Selenium\\drivery\\geckodriver.exe";
       /* String path = "C:\\Users\\olo88\\Desktop\\Selenium\\drivery\\IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", path);
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.withInitialBrowserUrl("https://www.google.pl/");*/
        WebDriver driver = getDriver("chromek");
        driver.get("https://www.google.pl/");
    }

    public WebDriver getDriver(String browser){
       switch (browser){
           case "chrome":
               String chromePath = "C:\\Users\\olo88\\Desktop\\Selenium\\drivery\\chromedriver.exe";
               System.setProperty("webdriver.chrome.driver", chromePath);
               return new ChromeDriver();
           case "firefox":
               String firefoxPath = "C:\\Users\\olo88\\Desktop\\Selenium\\drivery\\geckodriver.exe";
               System.setProperty("webdriver.gecko.driver", firefoxPath);
               return new FirefoxDriver();
           case "ie":
               String iePath = "C:\\Users\\olo88\\Desktop\\Selenium\\drivery\\IEDriverServer.exe";
               System.setProperty("webdriver.ie.driver", iePath);
               return new InternetExplorerDriver();
           default:
               throw new InvalidArgumentException("InvalidBrowserName");
       }
    }
}
