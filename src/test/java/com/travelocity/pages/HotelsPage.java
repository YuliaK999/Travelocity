package com.travelocity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.travelocity.utilities.Driver;

public class HotelsPage {
	
	public HotelsPage () {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (id = "primary-header-hotel")
	public WebElement hotelsMenu;
	
	@FindBy (xpath = "//button[contains(@aria-label,'Going to')]")
	public WebElement goingToField;
	
	@FindBy (xpath = "//input[@name='foo']")
	public WebElement destenationField;
	
	@FindBy (id = "hotels-check-in-btn")
	public WebElement checkInField;
	
	@FindBy (xpath = "//span[.='Aug 27, 2020']")
	public WebElement checkInCalendar;
	
	public WebElement date(String month, int day, int year) {
		WebDriver driver = new ChromeDriver();
		WebElement date = driver.findElement(By.xpath("//span[.='"+month+" "+day+", "+year+"']"));
		return date;
	}
	
	

}
