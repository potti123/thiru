package my_pack1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Way2sms 
{
	public ChromeDriver driver;
	public WebDriverWait w;
	@BeforeMethod
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","E:\\java258\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.way2sms.com");
		w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		driver.manage().window().maximize();
		
	}
		@Test
		@Parameters({"mbno","mbnoc","pwd","pwdc"}) 
		public void login(String x,String y,String z,String w) throws Exception 
		{
			driver.findElement(By.name("mobileNo")).sendKeys(x);
			driver.findElement(By.name("password")).sendKeys(z);
			driver.findElement(By.xpath("(//*[@type='button'])[4]")).click();;
			Thread.sleep(4000);
	try
	{
		if(x.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
		{
			Reporter.log("Blank mobile number test passed");
			Assert.assertTrue(true);
		}
		else if(x.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
		{
			Reporter.log("Wrong size mobile number test passed");
			Assert.assertTrue(true);
		}
		else if(z.length()==0 && driver.findElement(By.xpath("//*[test()='Enter password']")).isDisplayed())
		{
			Reporter.log("blank password test passed ");
			Assert.assertTrue(true);
		}
		else if(y.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'not register with us.')])[1]")).isDisplayed())
		{
			Reporter.log("invalid mobile number test passed");
			Assert.assertTrue(true);
			
		}
		else if(y.equalsIgnoreCase("valid") && w.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[contains(text(),'Try Again.')]")).isDisplayed())
		{
			Reporter.log("invalid pwd test passed");
			Assert.assertTrue(true);
	
		}
		else if(y.equalsIgnoreCase("valid") && w.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='Send SMS']")).isDisplayed())
		{
			Reporter.log("valid data test passed");
			Assert.assertTrue(true);
		}
		else
		{
			SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			Date d=new Date();
			String ssname=sf.format(d)+".png";
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("E:\\ssname");
			FileHandler.copy(src,dest);
			Reporter.log("login test failled");
			String sspath="E:\\"+ssname;
			String code="<img src=\"file:///"+sspath+"\"alt\"\">";
			Reporter.log(code);
			Assert.assertTrue(false);
		}
		
		
	}
	catch(Exception ex)
	{
		Reporter.log(ex.getMessage());
		Assert.assertTrue(true);
	}
		}
		@AfterMethod
		public void closesite()
		{
		driver.quit();
	
	}
	}
	
	
