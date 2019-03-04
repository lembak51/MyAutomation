package pages.desktopPages;


import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

public class DesktopDashboardPage extends BasePage {


    public DesktopDashboardPage(WindowsDriver driver){
        super(driver);
    }

    private void fillNumberFld(String userNumber){
        WebElement numberFld = desktop_driver.findElementByAccessibilityId("DialNumberTextBox");
        numberFld.sendKeys(userNumber);
    }

    private void clickCallBtn(){
        WebElement callBtn = desktop_driver.findElementByAccessibilityId("CallButton");
        callBtn.click();
    }

    private void clickEndCallBtn(){
        WebElement callBtn = desktop_driver.findElementByAccessibilityId("EndCall");
        callBtn.click();
    }

    public void makeCallToUser(String userNumber){
        waitUntilLoad(2);
        deployApplicationUsingDriver();
        fillNumberFld(userNumber);
        clickCallBtn();
        waitUntilLoad(5);
        clickEndCallBtn();
    }


}
