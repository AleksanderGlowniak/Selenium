import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage(){
        // String path = "C:\\Users\\olo88\\Desktop\\Selenium\\drivery\\geckodriver.exe";
       /* String path = "C:\\Users\\olo88\\Desktop\\Selenium\\drivery\\IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", path);
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.withInitialBrowserUrl("https://www.google.pl/");*/
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        /*Dimension windowSize = new Dimension(400, 400);
        driver.manage().window().setSize(windowSize);*/
        driver.get("https://www.google.pl/");
        /*JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://www.wp.pl','blank','height = 400, width = 400')");
        driver.close();*/

        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        // klikniecie przycisku
        agreeButton.click();
        // znajdz pole wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
        // wprowadz wartosc Selenium do pola
        searchField.sendKeys("Selenium");
        // zasymuluj nacisniecie przycisku Enter
        searchField.sendKeys(Keys.ENTER);
        // znalezc rezultat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));

        Assert.assertTrue(result.isDisplayed());

    }

    public WebDriver getDriver(String browser){
       switch (browser){
           case "chrome":
            //   String chromePath = "C:\\Users\\olo88\\Desktop\\Selenium\\drivery\\chromedriver.exe";
            //   System.setProperty("webdriver.chrome.driver", chromePath);
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
