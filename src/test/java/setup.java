import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class setup {
    AndroidDriver driver;
    @BeforeTest
    public AndroidDriver setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("appPackage", "com.continuum.emi.calculator");
        caps.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");
        caps.setCapability("app",  "C://Users//Hridoy//Pictures//SQA PROJECT//EmiCalculator.apk");

        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }
    @AfterTest
    public void closeApp() {

    }
}

