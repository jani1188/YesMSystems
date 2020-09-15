package Test;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class First {
	
	@Test(priority=2)
	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,36);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://magento.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("alam.marjan@gmail.com");
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("jani");
		driver.findElement(By.id("send2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")));
		String er = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
		System.out.println(er);
		if(er.equals("Invalid login or password.")) {
			System.out.println("Test Passed");
		}
		
		driver.close();
		
	}
	
	@Test(priority=4)
	public void login2() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,36);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://magento.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("alam.marjan@gmail.com");
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("jani");
		driver.findElement(By.id("send2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")));
		String er = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
		System.out.println(er);
		if(er.equals("Invalid login or password.")) {
			System.out.println("Test Passed");
		}
		
		driver.close();	
	}
	@Test(priority=3)
	public void regis() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://magento.com");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"block-header\\\"]/ul/li[9]/a/span[1]/div")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).sendKeys("Marjan");
		driver.findElement(By.id("lastname")).sendKeys("Alam");
		driver.findElement(By.id("email_address")).sendKeys("alam.marjan@gmail.com");
		
		
		//Drop Down Menu Select 
		Select cp = new Select(driver.findElement(By.id("company_type")));
		//cp.selectByIndex(3);
		cp.selectByValue("development");
		//cp.selectByVisibleText("Provides deployment, customization and integration services to merchants");
		Select ro = new Select(driver.findElement(By.id("individual_role")));
		ro.selectByValue("technical/developer");
		Select co = new Select(driver.findElement(By.id("country")));
		co.selectByValue("GE");
		
		driver.findElement(By.id("password")).sendKeys("Naziya123");
		driver.findElement(By.id("password-confirmation")).sendKeys("Naziya123");
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"msp-recaptcha-d84b65fc916e7398083ea5f17089d8f1\"]/div/div/iframe")));
		//driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
		//driver.switchTo().defaultContent();
		
		
		if(driver.findElement(By.id("agree_terms")).isSelected()) 
			
		{
		driver.findElement(By.id("agree_terms")).click();
		}
		driver.close();
	}
	@Test(priority=1)
	public void mouse() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com");
		//wait.until(ExpectedConditions.elementToBeSelected(By.xpath("ctl00_mainContent_rbtnl_Trip_0")));
		
		//Mouse Over
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"familyandfriend\"]/label"))).perform();
		
		//hard coded wait
		Thread.sleep(5000);
		
		//right click
		act.contextClick(driver.findElement(By.xpath("//*[@id=\"Covid19info\"]/span[2]"))).perform();
		
		driver.quit();
		
	}

}
