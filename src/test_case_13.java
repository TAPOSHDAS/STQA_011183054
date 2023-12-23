import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_case_13{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\88016\\Desktop\\cv\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //open source demo website
        driver.navigate().to("https://www.saucedemo.com");
        driver.manage().window().maximize();

        //locate username by id
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //locate password by name
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //locate login button
        driver.findElement(By.className("btn_action")).click();

        //Switch to product page
        String currentWindow=driver.getWindowHandle();
        driver.switchTo().window(currentWindow);


        ////img[@alt='Sauce Labs Backpack']

        //find web element image link open a product
        driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']")).click();
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory-item.html?id=4")){
            System.out.println("Test click on image for product  details pass");
        }else {
            System.out.println("Test click on image for product details fail");

        }






    }
}
