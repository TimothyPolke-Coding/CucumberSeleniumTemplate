package com.timothypolke.demo;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;

public class EbaySearchStepDefinition{
	
	SeleniumDriver selenium = null;
	Properties properties = null;

	@Before
	public void start(){
		
		properties = new Properties();
		
		try {
			properties.load(new FileReader(this.getClass().getClassLoader().getResource("config.properties").getPath().replace("%20", " ")));
		}
		catch(IOException e){
		}
		
		selenium = new SeleniumDriver(0, 1l, 15l);
		
		selenium.getDriver().manage().window().maximize();
	}
	
	@Given("^user is on home page$")
	public void user_is_on_home_page(){
		selenium.getDriver().get(properties.getProperty("homepage"));
		Assert.true(driver.findElement(By.xpath(properties.getProperty("searchtextfieldid")) != null);
	}
	
	@When("^user types in search parameter$")
	public void user_types_in_search_parameter(){
		selenium.getWait().until(ExpectedConditions.visibilityOf(selenium.getDriver().findElement(By.xpath(properties.getProperty("searchtextfieldid")))));
		selenium.getDriver().findElement(By.xpath(properties.getProperty("searchtextfieldxpath"))).click();
		selenium.getDriver().findElement(By.xpath(properties.getProperty("searchtextfieldxpath"))).sendKeys(properties.getProperty("searchparameter"));
	}
	
	@When("^user interacts with search button$")
	public void user_interacts_with_search_button(){
		selenium.getWait().until(ExpectedConditions.visibilityOf(selenium.getDriver().findElement(By.xpath(properties.getProperty("searchbuttonxpath")))));
		selenium.getDriver().findElement(By.xpath(properties.getProperty("searchbuttonxpath"))).click();
	}
	
	@Then("^user should see result$")
	public void user_should_see_result_count(){
		selenium.getWait().until(ExpectedConditions.visibilityOf(selenium.getDriver().findElement(By.xpath(properties.getProperty("resultxpath")))));
		Assert.assertNotNull(selenium.getDriver().findElement(By.xpath(properties.getProperty("resultxpath"))));
	}
	
	@After
	public void exit(){
		driver.quit();
	}
}