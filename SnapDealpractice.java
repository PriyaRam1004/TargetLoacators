package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDealpractice {

	public static void main(String[] args) throws InterruptedException, IOException {
ChromeDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.get("https://www.snapdeal.com/");
WebElement window = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
Actions act=new Actions(driver);

act.moveToElement(window).perform();
driver.findElement(By.xpath("(//span[@class='linkTest'])[1]")).click();
String items = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
System.out.println("The total Numeber of items: " +items);
driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
driver.findElement(By.xpath("(//li[@class='search-li'])[2]")).click();
Thread.sleep(3000);
driver.findElement(By.name("fromVal")).clear();
driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("500");
driver.findElement(By.name("toVal")).clear();
driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("700");
driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::label)[2]")).click();
Thread.sleep(2000);
WebElement img = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
Actions act1=new Actions(driver);
act1.moveToElement(img).perform();
driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]")).click();
Thread.sleep(2000);
String discountprice = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
System.out.println("The Discount Price is: " +discountprice);
WebElement snapshot = driver.findElement(By.xpath("//img[@class='cloudzoom']"));
File scr = snapshot.getScreenshotAs(OutputType.FILE);
File dst=new File("./Screenshot/img2.png");
FileUtils.copyFile(scr, dst);
driver.close();

	}
}
