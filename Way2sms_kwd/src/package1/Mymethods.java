package package1;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Mymethods
{
	public WebDriver driver;
	public String launch(String e,String d,String c) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E://java258//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(d);
		Thread.sleep(5000);
		return("done");
	}
	 public String fill(String e,String d,String c)
	 {
		driver.findElement(By.xpath(e)).sendKeys(d); 
		return("Done");
	 }
	 public String click(String e,String d,String c) throws InterruptedException
	 {
		 driver.findElement(By.xpath(e)).click();
		 Thread.sleep(5000);
		 return("Done");
		 
	 }
	 public String validation(String e,String d,String c) throws Exception
	 {
		 try 
		 {
		 
			 if(c.equals("all_valid") && driver.findElement(By.xpath("//*[text()='Send SMS']")).isDisplayed())
			 {
				 return("passed");
			 }
				 
			 else if(c.equals("mbno_blank") && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
			 {
				 return("passed");
			 }
			 else if(c.equals("mbno_invalid")&&driver.findElement(By.xpath("//*[text()='Your mobile number is not register with us.']")).isDisplayed())
			 {
				 return("passed");
				 
			 }
			 else if(c.equals("pwd_blank")&&driver.findElement(By.xpath("//*[text()='Enter password']")).isDisplayed())
			 {
				 return("passed");
			 }
			 else if(c.equals("pwd_invalid")&&driver.findElement(By.xpath("//*[text()='Incorrect number or password! Try Again.']")).isDisplayed())
			 {
				 return("passed");
				 
			 }
			 else
			 {
				 String temp=this.screenshot();
				 return("Test failed & go to "+temp+".png");
				 
			 }
		 }
		 catch(Exception ex) 
		 {
			 String temp=this.screenshot();
			 return("Test interrupted & go to "+temp+".png");
		 }
		 
	 }
	 
	 public String closesite(String e,String d,String c)
	 {
		driver.close();
		return("Done");
	 }
	 	public String screenshot() throws IOException
	 	{
	 		Date dt=new Date();;
	 		String ssname=dt.toString();
	 		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 		File dest=new File(ssname+".png");
	 		FileUtils.copyFile(src,dest);
			return(ssname);
	 		
	 	}
	 
}
