import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class test_case_18 {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\88016\\Desktop\\cv\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to the SauceDemo website
        driver.get("https://www.saucedemo.com/v1/");

        // Log in with valid credentials
        login(driver, "standard_user", "secret_sauce");

        // Define a list of product names to delete from the cart
        List<String> productsToDelete = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light");

        // Add products to the cart
        addProductsToCart(driver, productsToDelete);

        // Remove products from the cart
        deleteProductsFromCart(driver, productsToDelete);

        // Perform any additional steps as needed (e.g., go to the shopping cart)

        // Close the browser
        driver.quit();
    }

    // Login function
    private static void login(WebDriver driver, String username, String password) {
        // Locate username input field and enter username
        WebElement usernameField = driver.findElement(By.id("standard_user"));
        usernameField.sendKeys(username);

        // Locate password input field and enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        // Locate login button and click
        WebElement loginButton = driver.findElement(By.cssSelector("input.btn_action"));
        loginButton.click();
    }

    // Add products to cart function
    private static void addProductsToCart(WebDriver driver, List<String> products) {
        for (String productName : products) {
            // Locate the product by its name
            WebElement product = driver.findElement(By.xpath("//div[text()='" + productName + "']"));

            // Click on the "Add to Cart" button
            WebElement addToCartButton = product.findElement(By.xpath("ancestor::div[@class='inventory_item']//button"));
            addToCartButton.click();
        }
    }

    // Delete products from cart function
    private static void deleteProductsFromCart(WebDriver driver, List<String> products) {
        // Navigate to the shopping cart
        WebElement shoppingCartIcon = driver.findElement(By.cssSelector("div.shopping_cart_container"));
        shoppingCartIcon.click();

        for (String productName : products) {
            // Locate the product in the cart by its name
            WebElement product = driver.findElement(By.xpath("//div[@class='cart_item']//div[text()='" + productName + "']"));

            // Locate the "Remove" button for the product and click it
            WebElement removeButton = product.findElement(By.xpath("following-sibling::div[@class='cart_item_label']//button"));
            removeButton.click();
        }
    }
}










