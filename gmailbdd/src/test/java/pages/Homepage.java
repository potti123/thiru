package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	public WebDriver driver;

	@FindBy(name="identifier")
	public WebElement uid;

	@FindBy(xpath="//*[text()='Next']")
	public WebElement uidnext;

	@FindBy(xpath="//*[contains(text(),'Enter an email')]")
	public WebElement blankuiderr;

	@FindBy(xpath="(//*[contains(text(),'find your Google')])[2]")
	public WebElement invaliduiderr;

	public Homepage(WebDriver x)
	{
		this.driver=x;
		PageFactory.initElements(driver,this);
	}
	public void filluid(String x)
	{
		uid.sendKeys(x);
	}
		public void clickuidnext()
		{
			uidnext.click();
		}
}
