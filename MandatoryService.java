package week7.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MandatoryService {

	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev140572.service-now.com\r\n");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("P-qQ7@umSYz8");
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[text()='Knowledge']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.id("lookup.kb_knowledge.kb_knowledge_base")).click();
		Set<String>windowHandle=driver.getWindowHandles();
		List<String>windowHandle1=new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowHandle1.get(1));
		driver.findElement(By.linkText("IT")).click();
		Set<String>windowHandle2=driver.getWindowHandles();
		List<String>windowHandle3=new ArrayList<String>(windowHandle2);
		driver.switchTo().window(windowHandle3.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("Hi");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		}
		}
