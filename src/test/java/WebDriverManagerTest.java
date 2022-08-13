import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

public class WebDriverManagerTest {

    @Test
    public void openBrowser() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();

    }
}
