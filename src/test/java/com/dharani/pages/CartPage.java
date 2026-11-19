package com.dharani.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {
    private final By itemNames = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getItemNames() {
        visible(itemNames);
        return driver.findElements(itemNames).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
