

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo_wbshop_login {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();  // it will navigate to new page in web browser
		driver.get("https://demowebshop.tricentis.com/");
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();	//to maximize page we are using this method
		
		//To click the login button
		driver.findElement(By.xpath("//a[normalize-space()=\"Log in\"]")).click();
		
		//We are given invalid email,, valid password
		driver.findElement(By.id("Email")).sendKeys("kummthanyagmail.com");
		driver.findElement(By.id("Password")).sendKeys("7386162996");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		System.out.println	(driver.findElement(By.xpath("//span[text()=\"Please enter a valid email address.\"][1]")).getText());
		driver.navigate().refresh();
			
		//screenshot method
		WebElement section=driver.findElement(By.xpath("//div[@class='customer-blocks']"));
		File src=section.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\screen shot\\hgb.dpg"));
		System.out.println("  wrong email is screenshot is successfully");
		Thread.sleep(3000);
		// invalid password,,, valid email
		
		driver.findElement(By.id("Email")).sendKeys("kummethasowjanya12@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("selinium");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class=\"validation-summary-errors\"]")).getText());
	  	Thread.sleep(3000);
		
		
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Password")).clear();
		
		
		Thread.sleep(3000);
		
		//valid user name and valid password
		
		driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("kummethasowjanya12@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("7386162996");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).submit();
			Thread.sleep(3000);
		WebElement section1=driver.findElement(By.xpath("//div[@class=\"master-wrapper-content\"]"));
		File trg=section1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(trg, new File("C:\\screen shot\\jhg.yhg"));
		// logout
		
		//driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		
		
		
		
		
		
	}
}
