package ClassTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello World");

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Training\\java 7 lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// OPEN LOGIN SCREEN

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		// LOGIN TO THE WEB

				WebElement username;
				username = driver.findElement(By.id("input-email"));
				username.sendKeys("fariha_aslam@live.com");

				WebElement password;
				password = driver.findElement(By.id("input-password"));
				password.sendKeys("pass123");

				WebElement LoginButton;
				LoginButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
				LoginButton.click();


				//TO CHECK THE EXPECTED PAGE IS OPENED AFTER LOGIN

				String ActualPageTitle = driver.getTitle();
				String ExpectedPageTitle = "My Account";
				if(ActualPageTitle.contentEquals(ExpectedPageTitle))
				{
				    System.out.println("Test Passed!");
				} else {
				    System.out.println("Test Failed");
				}


				// SEARCH THE ITEM

				WebElement SearchBox;
				SearchBox = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
				SearchBox.sendKeys("hp lp 3065");

				WebElement SearchButton;
				SearchButton = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
				SearchButton.click();


				// ADD ITEM IN THE CART

				WebElement CartIconButton;
				CartIconButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]"));
				CartIconButton.click();

				WebDriverWait wait = new WebDriverWait(driver, 10);

				WebElement AddtoCartButton = wait.until(ExpectedConditions.elementToBeClickable((By.id("button-cart"))));
				AddtoCartButton.click();


				//TO NAVIGATE ON CHECKOUT SCREEN

				WebElement ItemButton;
				ItemButton = driver.findElement((By.xpath("//*[@id=\"cart\"]/button")));
				ItemButton.click();

				WebElement CheckoutLink = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong"))));
				CheckoutLink.click();


				//WAIT TO FIND ELEMENTS ON CHECKOUT SCREEN

				try {
					Thread.sleep(5000);
				 } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 } 


				// BILLING DETAILS

				WebElement radioBtn = driver.findElement(By.xpath("//*[@id=\"collapse-payment-address\"]/div/form/div[3]/label/input"));
				radioBtn.click();


				//ADD ADDRESS DETAILS

				WebElement FirstName = wait.until(ExpectedConditions.elementToBeClickable((By.id("input-payment-firstname"))));
				FirstName.sendKeys("Fariha");
				WebElement LastName = wait.until(ExpectedConditions.elementToBeClickable((By.id("input-payment-lastname"))));
				LastName.sendKeys("Aslam");
				WebElement Company = wait.until(ExpectedConditions.elementToBeClickable((By.id("input-payment-company"))));
				Company.sendKeys("Digital Dividend");
				WebElement Address1 = wait.until(ExpectedConditions.elementToBeClickable((By.id("input-payment-address-1"))));
				Address1.sendKeys("R-18, Row 5, Block E");
				WebElement Address2 = wait.until(ExpectedConditions.elementToBeClickable((By.id("input-payment-address-2"))));
				Address2.sendKeys("C158/1, Block 9");
				WebElement City = wait.until(ExpectedConditions.elementToBeClickable((By.id("input-payment-city"))));
				City.sendKeys("Karachi");
				WebElement PostCode = wait.until(ExpectedConditions.elementToBeClickable((By.id("input-payment-postcode"))));
				PostCode.sendKeys("75300");


				//SELECT COUNTRY DROPDOWN OPTION

				Select Country = new Select(driver.findElement(By.id("input-payment-country")));
				Country.selectByVisibleText("Pakistan");
				try {
					Thread.sleep(3000);
				 } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 } 


				//SELECT REGION/STATE DROPDOWN OPTION

				Select StateSelected = new Select(driver.findElement(By.id("input-payment-zone")));
				StateSelected.selectByVisibleText("Federally Administered Tribal Areas");


				//SUBMIT NEW ADDRESS DETAILS

				WebElement ContinueButton;
				ContinueButton = driver.findElement(By.id("button-payment-address"));
				ContinueButton.click();

				try {
					Thread.sleep(3000);
				 } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 } 


				// DELIVERY DETAILS

				Select DeliveryExistingAddress = new Select(driver.findElement(By.xpath("//*[@id=\"shipping-existing\"]/select")));
				DeliveryExistingAddress.selectByValue("4771");

				WebElement ContinueButton2;
				ContinueButton2 = driver.findElement(By.id("button-shipping-address"));
				ContinueButton2.click();


				//DELIVERY METHOD

				WebElement DeliveryMethod = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"collapse-shipping-method\"]/div/p[4]/textarea"))));
				DeliveryMethod.sendKeys("This is delivery method description");

				WebElement ContinueButton3;
				ContinueButton3 = driver.findElement(By.id("button-shipping-method"));
				ContinueButton3.click();


				//PAYMENT METHOD

				WebElement PaymentMethod = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"collapse-payment-method\"]/div/p[3]/textarea"))));
				PaymentMethod.sendKeys("\nThis is payment method description");

				WebElement Checkbox = driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]"));
				Checkbox.click();

				WebElement ContinueButton4;
				ContinueButton4 = driver.findElement(By.id("button-payment-method"));
				ContinueButton4.click();


				//CONFIRM ORDER

				//WebElement ContinueButton5;
				//ContinueButton5 = driver.findElement(By.id("button-confirm"));
				//ContinueButton5.click();

				System.out.println("Form Filled Successfully");
	}

}

