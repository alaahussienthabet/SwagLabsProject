package SwagLabsTest;

import Moduls.FilesReaders.PropertyFileReader;
import UI.UiActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


/**
 * base class that have all basic info and actions across all tests
 */
public class BaseClass {


    @BeforeMethod
    /**
     * function that switch to possible browsers that can use in tests and navigate to URL
     * @optional to run tests by default value = (chrome)
     */
    public void beforeClass(@Optional("firefox") String Browser) {


        switch (Browser) {

            case "chrome": // run tests by chrome
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                WebDriverManager.chromedriver().setup();
                UiActions.driver = new ChromeDriver(options);

                break;
            case "firefox": //run tests by firefox
                WebDriverManager.firefoxdriver().setup();

                UiActions.driver = new FirefoxDriver();
                break;
            case "internet explorer": //run tests by internet explore
                WebDriverManager.iedriver().setup();
                UiActions.driver = new InternetExplorerDriver();
                break;
            case "opera": //run tests by opera
                WebDriverManager.operadriver().setup();
                UiActions.driver = new OperaDriver();
                break;
        }

        UiActions.driver.manage().window().maximize();
        //navigate to specific URL
        String[] fileData = (PropertyFileReader.propertiesFileReader(new String[]{"URL"}));
        UiActions.driver.navigate().to(fileData[0]);

        UiActions.wait = new WebDriverWait(UiActions.driver, 100);
    }


}
