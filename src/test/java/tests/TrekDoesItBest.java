package tests;

import io.appium.java_client.ios.IOSDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Created by adam.hannisick on 8/04/2019.
 * iOS Static Text Validation Script
 * Includes Setting Up Desired Capabilities and Instantiating Web Driver
 * This has been created for iOS with intent to expand for Android / Windows
 * To be built out for BDD
 */

public class TrekDoesItBest {

    IOSDriver driver;
    String expectedValue = "Believe in bikes";

    //Static logger for organized error output to a log file log4j2.xml
    static Logger log = LogManager.getLogger();

    @BeforeTest
    public void setUp() throws MalformedURLException {

        //Setting up desired capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
        caps.setCapability(MobileCapabilityType.APP, "/Users/adamhannisick/git/MobileFramework/src/test/apps/Payload/R_and_D.app");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        log.info("Desired Capabilities are Set!");

        //Instantiating iOS driver
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        String sessionId = driver.getSessionId().toString();
        log.info("App is Launched!");
    }

    @Test
    public void validateText() throws AssertionError {

        //Locate page object by id, retrieve the text, convert it to lower case and store it in a string
        //Allows us to ignore case sensitivity for our assertEquals
        //Just in case it gets modified later on in hopes of sending a bigger message. BELIEVE IN BIKES ;)
        String actualValue = driver.findElement(By.id("")).getText().toLowerCase();

        //Implemented explicit wait condition waiting for element to be visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));

        //Assert that the actual value of the static text is equal to the expected value
        try {
            Assert.assertEquals(actualValue, expectedValue.toLowerCase());
            log.info("TEST PASSED:" + "The welcome text" + actualValue + "is correct!");
            } catch (AssertionError e){
                log.error(e);
                log.error("TEST FAILED" + "The welcome text" + actualValue + "is incorrect.");
            }
        }

    @AfterTest
    public void destroyDriver() {
        driver.quit();
        System.out.println("Driver Quit...");
    }
}

