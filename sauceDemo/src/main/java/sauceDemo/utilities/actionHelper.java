package sauceDemo.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class actionHelper {
	WebDriver driver;
	
	public static List <String> strList = new ArrayList<String>();
	List <Double> dblList = new ArrayList<Double>();
	
	@SuppressWarnings("null")
	public List<String> convertWebElementtoText(List<WebElement> WebElementList){
		strList.clear();
		for(int i = 0; i<WebElementList.size(); i++) {
			strList.add(WebElementList.get(i).getText().replace("$", ""));
		}
		return strList;
	}
	
	@SuppressWarnings("null")
	public List<Double> sortNumberswithDec(List<String> list, String order) {
		
		for(int i=0; i<list.size(); i++) {
			dblList.add(Double.parseDouble(list.get(i)));
		}
		if(order.equalsIgnoreCase("ascending")){
			Collections.sort(dblList);
		}else {
			Collections.sort(dblList, Collections.reverseOrder());
		}	
		return dblList;
	}
	
	public void scrollDownPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This  will scroll down the page by 350 pixel vertical		
	    js.executeScript("window.scrollBy(0,350)");
	}

}
