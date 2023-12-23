import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class test_case_12{
    public static void main(String[] args) throws MalformedURLException {
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



        //find links on products page

        List<WebElement> LinkElements=driver.findElements(By.tagName("a"));
        int resCode=200;//valid links->200
        int brokenLinks=0;
        System.out.println("Total Links on productpage: "+LinkElements.size());
        for (WebElement element:LinkElements) {

            String url= element.getAttribute("href");
            try {
                URL urlLink=new URL(url);
                HttpURLConnection huc=(HttpURLConnection)urlLink.openConnection();
                huc.setRequestMethod("HEAD");
                huc.connect();

                resCode=huc.getResponseCode();

                if (resCode>=400){
                    System.out.println(url+"Broken link.");
                    brokenLinks++;
                }

            }
            catch (MalformedURLException e){

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("Total broken Links: "+brokenLinks);


    }
}
