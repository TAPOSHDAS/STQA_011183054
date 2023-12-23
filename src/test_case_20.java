import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_case_20{
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\88016\\Desktop\\cv\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Swag Labs website
        driver.get("https://www.saucedemo.com");

        // Log in with valid credentials
        login(driver, "standard_user", "secret_sauce");

        // Add a product to the cart
        addToCart(driver, "Sauce Labs Backpack");

        // Check the cart and verify the presence of the checkout button
        checkCartAndCheckout(driver);

        // Close the browser
        driver.quit();
    }

    // Login function
    private static void login(WebDriver driver, String username, String password) {
        // Locate username input field and enter username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username);

        // Locate password input field and enter password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        // Locate login button and click
        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();
    }

    // Add to cart function
    private static void addToCart(WebDriver driver, String productName) {
        // Locate the product by its name
        WebElement product = driver.findElement(By.xpath("//div[text()='" + productName + "']"));

        // Click on the "Add to Cart" button
        WebElement addToCartButton = product.findElement(By.xpath("ancestor::div[@class='inventory_item']//button"));
        addToCartButton.click();
    }

    // Check the cart and verify the presence of the checkout button
    private static void checkCartAndCheckout(WebDriver driver) {
        // Locate the shopping cart icon and click it
        WebElement shoppingCartIcon = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        shoppingCartIcon.click();

        // Verify the presence of the checkout button
        WebElement checkoutButton = driver.findElement(By.cssSelector("a.btn_action.checkout_button"));

        if (checkoutButton.isDisplayed()) {
            System.out.println("Checkout button is present in the cart. Test Passed!");
        } else {
            System.out.println("Checkout button is not present in the cart. Test Failed!");
        }
    }
}