package marathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingassignment {

	public static void main(String[] args) {
ChromeDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.get("http://leaftaps.com/opentaps/control/login");
driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
driver.findElement(By.linkText("CRM/SFA")).click();
driver.findElement(By.xpath("//a[text()='Contacts']")).click();
driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
Set<String> cus = driver.getWindowHandles();
List<String> print=new ArrayList<String>(cus);
driver.switchTo().window(print.get(1));
driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
driver.switchTo().window(print.get(0));
driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
Set<String> cus1 = driver.getWindowHandles();
List<String> print1=new ArrayList<String>(cus1);
driver.switchTo().window(print1.get(1));
driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
driver.switchTo().window(print.get(0));
driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
Alert alert = driver.switchTo().alert();
alert.accept();
String title = driver.getTitle();
System.out.println("The title Page is: "+title);
	}

}
