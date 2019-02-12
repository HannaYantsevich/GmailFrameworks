package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.AbstractedPage;

import java.io.File;

public class ScreenShoter extends AbstractedPage {
    private static final String SCREENSHOTS_NAME_TPL = "Screenshots/src";

    public ScreenShoter(WebDriver driver) {
        super(driver);
    }

    public static void takeScreenshot() {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
            System.out.println("Saved screenshot:" + screenshotName);
        } catch (Exception e) {
            System.out.println("Failed to make screenshot");
        }
    }
}


