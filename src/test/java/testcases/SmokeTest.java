package testcases;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class SmokeTest extends BaseTest{
    @Test
    public void sampleLoginTest2(){
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        loginPage.allowPermission();
        loginPage.login();
        profilePage.logout();
    }
}
