package com.travelocity.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travelocity.utilities.BrowserUtilities;
import com.travelocity.utilities.Driver;

public class FlightsPage {
	
	public FlightsPage () {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	@FindBy (id = "tab-flight-tab-hp")
	public WebElement flightsButton;
	
	@FindBy (id = "tab-hotel-tab-hp")
	public WebElement hotelsButton;
	
	@FindBy (xpath = "//button[@id='tab-flight-tab-hp']//span[@class='tab-label']")
	public WebElement flightsText;
	
	@FindBy (xpath = "//button[@class='btn btn-clear']")
	public WebElement clearButton;
	
	@FindBy (id = "flight-origin-hp-flight")
	public WebElement flyingFromAirport;
	
	@FindBy (xpath = "//div[@class='multiLineDisplay details']")
	public List<WebElement>	airportList;
		
	@FindBy (id = "flight-destination-hp-flight")
	public WebElement flyingToAirport;
	
	@FindBy (id = "flight-departing-hp-flight")
	public WebElement departingDate;
	
	@FindBy (id = "flight-returning-hp-flight")
	public WebElement returningDate;
	
	@FindBy (id = "flight-adults-hp-flight")
	public WebElement adultsNumber;
	
	@FindBy (id = "flight-children-hp-flight")
	public WebElement childrenNumber;
	
	@FindBy (className = "//form[@id='gcw-flights-form-hp-flight']//span[contains(text(),'Search')]")
	public WebElement searchButton;
	
	@FindBy (className = "multiLineDisplay details")
	public List<WebElement> options;
	
	@FindBy (className = "alert-title no-outline")
	public WebElement errorMessage;
	
	@FindBy(xpath = "(//caption[@class='datepicker-cal-month-header'])[1]")
	public WebElement leftMonthYear;
	
	@FindBy(xpath = "(//caption[@class='datepicker-cal-month-header'])[2]")
	public WebElement rightMonthYear;
	
	@FindBy(xpath = "//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")
	public WebElement rightArrow;
	
	@FindBy(xpath = "(//table)[1]")
	public WebElement leftCalendar;
	
	@FindBy(xpath = "(//table)[2]")
	public WebElement rightCalendar;
	
	@FindBy(id = "flight-age-select-1-hp-flight")
	public WebElement childAge;
	
	
	public void selectMonthYearDay (String month, String year, String day) {
		if (leftMonthYear.getText().equals(month.concat(" "+year)))
				selectCalendarDay(leftCalendar, day);
			else if (rightMonthYear.getText().contains(month.concat(" "+year)))
				selectCalendarDay(rightCalendar, day);
					else rightArrow.click();
	}
	
	public static void selectCalendarDay (WebElement calendar, String day) {
		List<WebElement> rows = calendar.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
				for (WebElement cell : cells) {
					if (cell.getText().contains(day)) {
						cell.click();
						break;
					}
				}
			}
	}
	
	public String generateKeyword() {
		String s = "gfk";
		int n = 1 + (int)(Math.random()*11);//random number from 1 to 10 
		for (int i=0; i<n; i++) {
			int rnd = new Random().nextInt(2); // 0 or 1
				if (rnd==0) 
					s += (char)(65 + Math.random()*26);//Capital letter
				else
					s += (char)(97 + Math.random()*26);//Lowcase letter
		}
		return s;
	}


}
