package tatoc;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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
		
		boolean condition =true;
				//driver.findElement(By.tagName("iframe"));

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
	    
	    driver.findElement(By.cssSelector("a")).click();
	  
	    ArrayList handle= new ArrayList(driver.getWindowHandles());
	    String window1=(String)handle.get(1);
	    driver.switchTo().window(window1);
	    WebElement inputfield= driver.findElement(By.id("name"));
	    inputfield.sendKeys("Shalini");
	    driver.findElement(By.id("submit")).click();
	    String window2=(String)handle.get(0);
	    driver.switchTo().window(window2);
	    driver.findElements(By.cssSelector("a")).get(1).click();
	    
	    driver.findElement(By.cssSelector("a")).click();
	    String Token=driver.findElement(By.id("token")).getText();
	    System.out.println(Token);
	    String tokendata=Token.substring(7);
	    Cookie name=new Cookie("Token", tokendata);
	    driver.manage().addCookie(name);
	    
	    driver.findElements(By.cssSelector("a")).get(1).click();
	    
	    
	    
	    
	}
	


}

