# Selenium TestNG Framework

UI test automation framework for the [SauceDemo](https://www.saucedemo.com/) web app, built with **Selenium WebDriver (Java)**, **TestNG** and the **Page Object Model**.

## Tech stack
| Area | Tool |
|---|---|
| Language | Java 17+ |
| Browser automation | Selenium WebDriver 4 (Selenium Manager handles drivers) |
| Test runner | TestNG (data-driven tests with `@DataProvider`) |
| Build | Maven |
| Design pattern | Page Object Model with explicit waits |

## Project structure
```
src/test/java/com/dharani/
  base/BaseTest.java         browser setup and teardown
  pages/BasePage.java        shared explicit-wait helpers
  pages/LoginPage.java
  pages/InventoryPage.java
  pages/CartPage.java
  tests/LoginTest.java       valid login + 4 data-driven invalid logins
  tests/CartTest.java        add to cart, verify badge and cart page
  utils/ConfigReader.java    URL, demo users, browser options
testng.xml                   suite definition
```

## Test coverage
- Valid login lands on the Products page
- Invalid logins (locked user, wrong credentials, empty username, empty password) show the correct error
- Adding products updates the cart badge and the cart page

## How to run
```bash
mvn clean test                     # Chrome
mvn clean test -Dbrowser=edge      # Edge
mvn clean test -Dheadless=true     # headless Chrome
```
Reports are generated in `target/surefire-reports/`.

## Author
**Dharani Pothugunta**, Software Test Engineer · [LinkedIn](https://www.linkedin.com/in/dharani-potugunta-b3044b27b)
