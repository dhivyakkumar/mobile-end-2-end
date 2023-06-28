package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private AppiumDriver<AndroidElement> driver;
    public LoginPage() {
    }
    public LoginPage(AppiumDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "com.kaching.merchant.kiwi:id/btn_login")
    private AndroidElement loginElement;
    @AndroidFindBy(id = "android:id/button2")
    private AndroidElement askMeElement;

    @AndroidFindBy(id = "com.kaching.merchant.kiwi:id/continue_button")
    private AndroidElement continueElement;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private AndroidElement allowElement;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.widget.EditText")
    private AndroidElement emailElement;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[5]/android.widget.EditText")
    private AndroidElement passwordElement;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.Button")
    private AndroidElement nextElement;

    public void allowPermission() {
        askMeElement.click();
        loginElement.click();
        continueElement.click();
        allowElement.click();
    }
    public void login() {
        WaitTillVisible(emailElement);
        emailElement.sendKeys("dev_kpzujmqy@sumup.com");
        passwordElement.sendKeys("extdev");
        nextElement.click();

    }
    public void WaitTillVisible(AndroidElement element){
        new WebDriverWait(driver,90).until(ExpectedConditions.visibilityOf(element));
    }
}
