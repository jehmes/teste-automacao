package aula.com.br;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class SistemaAutomacaoTest {
	static SistemaAutomacao config;
	static WebDriver driver;
	static WebElement element;
	
	@BeforeAll
	public static void init() {
		config = new SistemaAutomacao();
		driver = config.getWebDriver();
	}
	

	@Test
	@DisplayName("TC002 - Automobile - Data de nascimento inferior a 18 anos")
	void testB() {
		driver.get("http://sampleapp.tricentis.com/101/app.php");
	
		//PREENCHIMENTO DA 1º ABA "ENTER VEHICLE DATA"
		
		element = driver.findElement(By.id("nav_automobile"));
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id=\"make\"]/option[4]"));
		element.click();				
		
		element = driver.findElement(By.id("engineperformance"));
		element.sendKeys("5");
				
		element = driver.findElement(By.id("dateofmanufacture"));
		element.sendKeys("02/05/2020");
		
		element = driver.findElement(By.xpath("//*[@id=\"numberofseats\"]/option[5]"));  
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id=\"fuel\"]/option[3]"));
		element.click();
		
		element = driver.findElement(By.id("listprice"));
		element.sendKeys("500");
		
		element = driver.findElement(By.id("annualmileage"));
		element.sendKeys("800");
		
		element = driver.findElement(By.id("nextenterinsurantdata"));
		element.click();
		
		//PREENCHIMENTO DA 2º ABA "ENTER INSURANT DATA"
		
		element = driver.findElement(By.id("firstname"));
		element.sendKeys("Nome");
		
		element = driver.findElement(By.id("lastname"));
		element.sendKeys("Teste");
		
		//********************************************AQUI É O ERRO********************************************
		element = driver.findElement(By.id("birthdate"));
		element.sendKeys("02/05/2015");
		
		element = driver.findElement(By.xpath("//*[@id=\"country\"]/option[32]"));
		element.click();
		
		element = driver.findElement(By.id("zipcode"));
		element.sendKeys("51250");
		
		element = driver.findElement(By.xpath("//*[@id=\"occupation\"]/option[2]"));
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[2]/span"));
		element.click();
		
		element = driver.findElement(By.id("nextenterproductdata"));
		element.click();
		
		//PREENCHIMENTO DA 3º ABA "ENTER PRODUCT DATA"
		
		String esperado = "display: none;";
		String atual;
		
		element = driver.findElement(By.id("startdate"));
		element.sendKeys("12/03/2021");
		
		element = driver.findElement(By.xpath("//*[@id=\"insurancesum\"]/option[2]"));
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id=\"meritrating\"]/option[4]"));
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id=\"damageinsurance\"]/option[3]"));
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]/span"));
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id=\"courtesycar\"]/option[2]"));
		element.click();
		
		element = driver.findElement(By.id("nextselectpriceoption"));
		element.click();
		
		atual = driver.findElement(By.xpath("//*[@id=\"pricePlans\"]")).getAttribute("style");
				
		
		assertEquals(esperado, atual, "Erro na data de nascimento");
		
		
	}
	
	@Test
	@DisplayName("TC003 - Motorcycle - Data de fabricação superior a data atual")
	void testC() {
		driver.get("http://sampleapp.tricentis.com/101/app.php");
	
		//PREENCHIMENTO DA 1º ABA "ENTER VEHICLE DATA"
		
		element = driver.findElement(By.id("nav_motorcycle"));
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id=\"make\"]/option[4]"));
		element.click();		
		
		element = driver.findElement(By.xpath("//*[@id=\"model\"]/option[2]"));
		element.click();
		
		element = driver.findElement(By.id("cylindercapacity"));
		element.sendKeys("50");
		
		element = driver.findElement(By.id("engineperformance"));
		element.sendKeys("5");
				
		//********************************************AQUI É O ERRO********************************************
		element = driver.findElement(By.id("dateofmanufacture"));
		element.sendKeys("02/05/2021");
		
		element = driver.findElement(By.xpath("//*[@id=\"numberofseatsmotorcycle\"]/option[2]"));  
		element.click();
			
		element = driver.findElement(By.id("listprice"));
		element.sendKeys("500");
		
		element = driver.findElement(By.id("annualmileage"));
		element.sendKeys("800");
		
		element = driver.findElement(By.id("nextenterinsurantdata"));
		element.click();
		
		//PREENCHIMENTO DA 2º ABA "ENTER INSURANT DATA"
		
		element = driver.findElement(By.id("firstname"));
		element.sendKeys("Nome");
		
		element = driver.findElement(By.id("lastname"));
		element.sendKeys("Teste");		
		
		element = driver.findElement(By.id("birthdate"));
		element.sendKeys("02/05/1996");
		
		element = driver.findElement(By.xpath("//*[@id=\"country\"]/option[32]"));
		element.click();
		
		element = driver.findElement(By.id("zipcode"));
		element.sendKeys("51250");
		
		element = driver.findElement(By.xpath("//*[@id=\"occupation\"]/option[2]"));
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[2]/span"));
		element.click();  
		
		element = driver.findElement(By.id("nextenterproductdata"));
		element.click();
		
		//PREENCHIMENTO DA 3º ABA "ENTER PRODUCT DATA"
		
		String esperado = "display: none;";
		String atual;
		
		element = driver.findElement(By.id("startdate"));
		element.sendKeys("12/03/2021");
		
		element = driver.findElement(By.xpath("//*[@id=\"insurancesum\"]/option[2]"));
		element.click();
			
		element = driver.findElement(By.xpath("//*[@id=\"damageinsurance\"]/option[3]"));
		element.click();
		
		element = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[4]/p/label[1]/span"));
		element.click();
	
		element = driver.findElement(By.id("nextselectpriceoption"));
		element.click();
		
		atual = driver.findElement(By.xpath("//*[@id=\"pricePlans\"]")).getAttribute("style");
				
		
		assertEquals(esperado, atual, "Erro na data de fabricação");
		
		
	}
	
	@AfterAll
	public static void terminate() {
		config.killAndCloseWebDriver();
	}

}
