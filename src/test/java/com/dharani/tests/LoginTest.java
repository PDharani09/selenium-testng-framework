package com.dharani.tests;

import com.dharani.base.BaseTest;
import com.dharani.pages.InventoryPage;
import com.dharani.pages.LoginPage;
import com.dharani.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Valid user lands on the Products page")
    public void validLogin() {
        InventoryPage inventory = new LoginPage(driver).loginAs(ConfigReader.VALID_USER, ConfigReader.PASSWORD);
        Assert.assertEquals(inventory.getTitle(), "Products");
    }

    @DataProvider(name = "invalidLogins")
    public Object[][] invalidLogins() {
        return new Object[][] {
            {ConfigReader.LOCKED_USER, ConfigReader.PASSWORD, "Sorry, this user has been locked out."},
            {"wrong_user", "wrong_pass", "Username and password do not match"},
            {"", ConfigReader.PASSWORD, "Username is required"},
            {ConfigReader.VALID_USER, "", "Password is required"},
        };
    }

    @Test(dataProvider = "invalidLogins", description = "Invalid logins show the right error (data-driven)")
    public void invalidLoginShowsError(String user, String pass, String expectedError) {
        LoginPage login = new LoginPage(driver);
        login.loginAs(user, pass);
        Assert.assertTrue(login.getErrorMessage().contains(expectedError),
            "Expected error to contain: " + expectedError);
    }
}
