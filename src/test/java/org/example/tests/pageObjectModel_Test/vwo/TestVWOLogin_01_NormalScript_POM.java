package org.example.tests.pageObjectModel_Test.vwo;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.pages.pageObjectModel.vwo.normal_POM.DashBoardPage;
import org.example.pages.pageObjectModel.vwo.normal_POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_01_NormalScript_POM {

    @Owner("ASHU")
    @Description("TC#1-Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {
        // Driver Manager Code - 1
        WebDriver driver = new ChromeDriver();


        // Page Class Code (POM Code) - 2
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOLoginInvalidCreds("admin@gmail.com","1234");

        // Assertions - 3
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

        driver.quit();


    }

    @Owner("ASHU")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        // Driver Manager Code - 1
        WebDriver driver = new ChromeDriver();

        // Page Class Code (POM Code) - 2
        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginValidCreds("hebiva4776@amcret.com","Test@4321");

        DashBoardPage dashBoardPage  = new DashBoardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();


        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Amcret");


        driver.quit();

    }
}
