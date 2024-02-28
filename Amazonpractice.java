package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazonpractice {

	public static void main(String[] args) throws IOException, InterruptedException {
ChromeDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.get("https://www.amazon.in/");
 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 9 pro");
 driver.findElement(By.id("nav-search-submit-button")).click();
 String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The Product Price is: "+price);
		String rating = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("The total number of reviews: " +rating);
		WebElement shot = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
	shot.click();
	File scr = shot.getScreenshotAs(OutputType.FILE);
	File dst=new File("./Screenshot/img1.png");
	FileUtils.copyFile(scr, dst);
	Set<String> window = driver.getWindowHandles();
	List<String> window1=new ArrayList<String>(window);
	driver.switchTo().window(window1.get(1));
 	driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']")).click();
 	Thread.sleep(3000);
	String subtotal = driver.findElement(By.xpath("//span[@class='a-price sw-subtotal-amount']")).getText();
	System.out.println("The Subtotal Of The Product: " +subtotal);
	driver.close();	
	}

}
	