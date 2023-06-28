package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private AppiumDriver<AndroidElement> driver;
    @AndroidFindBy(id = "com.kaching.merchant.kiwi:id/ivProfilePlaceholder")
    private AndroidElement profileElement;

    @AndroidFindBy(id = "com.kaching.merchant.kiwi:id/itemProfileMenuLayout")
    private AndroidElement logoutElement;

    public ProfilePage(AppiumDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void logout() {
        WaitTillVisible(profileElement);
        profileElement.click();
        logoutElement.click();
    }

    public void WaitTillVisible(AndroidElement element){
        new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(element));
    }
}
