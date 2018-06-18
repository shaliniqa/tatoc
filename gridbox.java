package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class gridbox {
	public static void main(String args[])
	{
		String exepath="/home/qainfotech/chromedriver";
		System.setProperty("webdriver.chrome.driver", exepath);
		WebDriver driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.className("greenbox")).click();
		
		driver.findElement(By.tagName("iframe"));
		boolean condition =true;
		
		driver.switchTo().frame(0);
		String boxcolor = 
		driver.findElement(By.id("answer")).getAttribute("class");
		
	    while(true)
	    {
	        
	        driver.findElement(By.cssSelector("a")).click();
			driver.switchTo().frame("child");
	        String tomatchbox=driver.findElement(By.id("answer")).getAttribute("class");
	        //driver.switchTo().defaultContent();
	        driver.switchTo().parentFrame();
	        
	        if(boxcolor.equals(tomatchbox))
	        {
	        	driver.findElements(By.cssSelector("a")).get(1).click();
	        	break;
	        	
	        }
	
	    }
	    WebElement source = driver.findElement(By.id("dragbox"));
	    
	    WebElement target = driver.findElement(By.id("dropbox"));
	    Actions act=new Actions(driver);
	    act.dragAndDrop(source, target).build().perform();

	    driver.findElement(By.cssSelector("a")).click();
	}
	


}
