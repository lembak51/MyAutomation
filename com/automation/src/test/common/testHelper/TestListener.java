package common.testHelper;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private static final String SCREENSHOT_FOLDER = System.getProperty("user.dir") + File.separator + "logs" + File.separator + "screen" + File.separator + new SimpleDateFormat("MM_dd__hh_mm").format(new Date()) + File.separator;
    protected Logger log = Logger.getLogger(this.getClass().getSimpleName());
    private WebDriver driver = new BaseTest().driver;

    @Override
    public void onTestFailure(ITestResult result) {
        String testClassName = getTestClassName(result.getInstanceName()).trim() + File.separator;
        String tcNumber = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description().split(" ", 2)[0];
        log.info("***** Error " + tcNumber + " - " + result.getName() + " test has failed *****");
        takeScreenShot(tcNumber, SCREENSHOT_FOLDER + testClassName + tcNumber + ".png");
        saveScreenshot(result);
        log.info("Test FAILED: " + result.getName());
    }

    public void onFinish(ITestContext context) {
    }

    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {
    }

    public void onTestSkipped(ITestResult result) {
        String testClassName = getTestClassName(result.getInstanceName()).trim() + File.separator;
        String tcNumber = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description().split(" ", 2)[0];
        log.info("***** Error " + tcNumber + " - " + result.getName() + " test has failed *****");
        takeScreenShot("Skipped " + tcNumber, SCREENSHOT_FOLDER + testClassName + tcNumber + ".png");
        saveScreenshot(result);
        log.info("Test FAILED: " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        String testClassName = getTestClassName(result.getInstanceName()).trim() + File.separator;
        String meatestNumber = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description().split(" ", 2)[0];
        log.info("***** Error " + meatestNumber + " - " + result.getName() + " test has failed *****");
        takeScreenShot(meatestNumber, SCREENSHOT_FOLDER + testClassName + meatestNumber + ".png");
        saveScreenshot(result);
        log.info("Test FAILED: " + result.getName());
    }

    public void onStart(ITestContext context) {
    }

    private void takeScreenShot(String tcNumbber, String pathName) {
        File scrFile;
        try {
            scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(pathName));
            log.info("*** Placed screenshot in '" + pathName + "' ***\n\n");
        } catch (IOException | NullPointerException e) {
            System.out.println("File can not be created because driver is not initializate");
            e.printStackTrace();
        }
    }

    private String getTestClassName(String testName) {
        String[] reqTestClassname = testName.split(File.separator + ".");
        int i = reqTestClassname.length - 1;
        log.info("Test Name : " + reqTestClassname[i]);
        return reqTestClassname[i];
    }

    private byte[] saveScreenshot(ITestResult result) {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (NullPointerException e) {
            System.out.println("File can not be created because driver is not initializate");
            return null;
        }
    }
}
