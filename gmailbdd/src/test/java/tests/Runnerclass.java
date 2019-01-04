package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"E:\\java258(2)\\eclipse\\thirupathi\\gmailbdd\\src\\test\\resources\\gmailresources\\feature1.feature","E:\\java258(2)\\eclipse\\thirupathi\\gmailbdd\\src\\test\\resources\\gmailresources\\feature2.feature"},plugin={"pretty","html:target/result2"},monochrome=true)
public class Runnerclass 
{

}
