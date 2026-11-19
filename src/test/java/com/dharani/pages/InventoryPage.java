package com.dharani.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    private final By title = By.className("title");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartLink = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return visible(title).getText();
    }

    /** Adds a product by its visible name, e.g. "Sauce Labs Backpack". */
    public InventoryPage addToCart(String productName) {
        By addButton = By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button");
        click(addButton);
        return this;
    }

    public int getCartCount() {
        return Integer.parseInt(visible(cartBadge).getText());
    }

    public CartPage openCart() {
        click(cartLink);
        return new CartPage(driver);
    }
}
