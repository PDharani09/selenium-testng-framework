package com.dharani.tests;

import com.dharani.base.BaseTest;
import com.dharani.pages.CartPage;
import com.dharani.pages.InventoryPage;
import com.dharani.pages.LoginPage;
import com.dharani.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CartTest extends BaseTest {

    @Test(description = "Added products show in the cart badge and cart page")
    public void addProductsToCart() {
        InventoryPage inventory = new LoginPage(driver).loginAs(ConfigReader.VALID_USER, ConfigReader.PASSWORD)
            .addToCart("Sauce Labs Backpack")
            .addToCart("Sauce Labs Bike Light");

        Assert.assertEquals(inventory.getCartCount(), 2);

        CartPage cart = inventory.openCart();
        List<String> items = cart.getItemNames();
        Assert.assertTrue(items.contains("Sauce Labs Backpack"));
        Assert.assertTrue(items.contains("Sauce Labs Bike Light"));
    }
}
