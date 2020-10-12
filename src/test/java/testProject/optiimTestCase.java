package testProject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import junit.framework.Assert;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class optiimTestCase {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {

		htmlReporter = new ExtentHtmlReporter("extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@Test
	public void f() throws InterruptedException, IOException {
		
// 		Creates a toggle for the given test, adds all log events under it 
		ExtentTest extentReport = extent.createTest("optiimTestCase");

//		Define Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		Manage time outs
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//		Open the link and maximize the window
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

//		Click login button
		driver.findElement(By.id("u_0_b")).click();
		Thread.sleep(3000L);

//		Write email,password and click the login button
		driver.findElement(By.id("email")).sendKeys("mmtalii86@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("facebooksifresi");
		Thread.sleep(2000L);
		
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(5000L);

// 		info(details)
		extentReport.info("Facebook sitesine giris yapildi.");

//		Navigate to the link 
		driver.navigate().to("http://www.n11.com/");

//		Check the link 
		if (driver.getCurrentUrl().contains("https://www.n11.com/")) {
			System.out.println("N11 sayfasina giris yapildi");
			System.out.println("-----------------------------");
		} else {
			throw new WebDriverException("N11 sayfasi acilamadi");
		}

		Assert.assertEquals("https://www.n11.com/", driver.getCurrentUrl());

// 		info(details)
		extentReport.info("N11 sitesine yonlendirme yapildi ve anasayfanin acildigi onaylandi.");

//	    Close the message
		Thread.sleep(2000L);
		driver.findElement(By.className("closeBtn")).click();

//	    Open the sign in page
		driver.findElement(By.className("btnSignIn")).click();
		Thread.sleep(3000L);

//		Login n11.com

		/*
		 * driver.findElement(By.id("email")).sendKeys("mmtalii86@gmail.com");
		 * Thread.sleep(2000L);
		 * driver.findElement(By.id("password")).sendKeys("n11girissifresi");
		 * Thread.sleep(2000L); driver.findElement(By.id("loginButton")).click();
		 * Thread.sleep(2000L);
		 */

		driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/div[@id='contentWrapper']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]"))
				.click();

// 		info(details)
		extentReport.info("N11 sitesine kullanici girisi yapildi.");

//		Search Samsung
		driver.findElement(By.id("searchData")).sendKeys("samsung");
		driver.findElement(By.xpath("//span[@class='icon iconSearch']")).click();
		Thread.sleep(2000L);

//    	Check searched product
		if (driver.getTitle().contains("Samsung - n11.com")) {
			System.out.println("Samsung aramasi yapildi");
			System.out.println("-----------------------------");
		} else {
			throw new WebDriverException("Samsung aramasi yapilamadi");
		}

		Assert.assertEquals("Samsung - n11.com", driver.getTitle());
		Thread.sleep(2000L);

// 		info(details)
		extentReport.info("Samsung aramasi yapildi.");

//		Go to the second page
		driver.findElement(By.xpath("//div[@class='pagination']//a[contains(text(),'2')]")).click();
		Thread.sleep(2000L);

//		Check second page
		if (driver.getCurrentUrl().contains("pg=2")) {
			System.out.println("2. sayfaya gecis yaptiniz");
			System.out.println("-----------------------------");

		} else {
			System.out.println("2. sayfaya gidemediniz");
		}

// 		info(details)
		extentReport.info("2.sayfaya gecis yapildi.");

//		Go to third product and fav
		driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/div[@id='contentListing']/div[1]/div[1]/div[2]/section[1]/div[2]/ul[1]/li[3]/div[1]/div[1]/span[1]"))
				.click();
		Thread.sleep(2000L);

		String thirdProductionTitle = driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/div[@id='contentListing']/div[1]/div[1]/div[2]/section[1]/div[2]/ul[1]/li[3]/div[1]/div[1]/a[1]/h3[1]"))
				.getText();
		System.out.println("3. urun : " + thirdProductionTitle);
		System.out.println("-----------------------------");

// 		info(details)
		extentReport.info("3.urun favorilere eklendi.");

//		My favourites
		driver.navigate().to("https://www.n11.com/hesabim/favorilerim");
		Thread.sleep(2000L);

// 		info(details)
		extentReport.info("Favorilerim linkine gidildi.");

		Assert.assertEquals(thirdProductionTitle, driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/div[@id='']/div[1]/div[2]/div[3]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/a[1]/h3[1]"))
				.getText());
		Thread.sleep(2000L);

// 		info(details)
		extentReport.info("Favorilerimdeki urunun 3.urun oldugu onaylandi.");

//		Delete my favourites
		driver.findElement(By.xpath("/html/body/div[4]/div/div/button/span")).click();
		driver.findElement(By.xpath("//span[@class='deleteProFromFavorites']")).click();
		Thread.sleep(2000L);

// 		info(details)
		extentReport.info("Urun favorilerim listesinden cikarildi.");

//		Check my favourites list
		WebElement checkMyFavorites = driver.findElement(By.xpath("//span[text()='Ürününüz listeden silindi.']"));

		if (checkMyFavorites != null) {
			System.out.println("Favori urun listenizde urun bulunmamaktadýr.");
			System.out.println("-----------------------------");
		} else {
			System.out.println("Favori urununuz listeden silinmedi");
			System.out.println("-----------------------------");
		}

		Thread.sleep(2000L);

// 		info(details)
		extentReport.info("Urunun favorilerde olmadigi onaylandi.");

//	    Close deleted product message
		driver.findElement(By.xpath("//span[contains(text(),'Tamam')]")).click();
		Thread.sleep(3000L);

// 		log(Status, details)
		extentReport.log(Status.INFO, "Test durum bilgisi");

// 		info(details)
		extentReport.info("Test tamamlandi.");

//		Close drivers
		driver.close();
		driver.quit();
		System.out.println("Test basariyla tamamlandi.");
		extent.flush();

	}

}
