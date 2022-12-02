package com.solera.selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Application {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000");
		try {
			pruebaDeAgregarOportunidad();
			Thread.sleep(3000);
			pruebaDeVerOportunidad();
			Thread.sleep(3000);
			pruebaDeBorrarOportunidad();
			Thread.sleep(3000);
			pruebaDeAgregarCliente();
			Thread.sleep(3000);
			pruebaDeBorrarClientes();
			Thread.sleep(3000);
			pruebaDeVerCliente();
			Thread.sleep(3000);
			pruebaDeAgregarContacto();
			Thread.sleep(3000);
			pruebaDeBorrarContactos();
		}catch (Exception e) {

		}
	}

	public static void pruebaDeAgregarOportunidad() throws Exception{
		WebElement btnOportunidades = driver.findElement(By.xpath("/html/body/div/div/header/nav/ul/li[2]/button"));
		btnOportunidades.click();

		Thread.sleep(1000);

		WebElement btnAddOportunidades = driver.findElement(By.xpath("/html/body/div/div/div/button"));
		btnAddOportunidades.click();

		Thread.sleep(1000);

		WebElement inputName = driver.findElement(By.xpath("/html/body/div/div/form/input[1]"));
		WebElement inputPhone = driver.findElement(By.xpath("/html/body/div/div/form/input[2]"));
		WebElement inputMail = driver.findElement(By.xpath("/html/body/div/div/form/input[3]"));
		WebElement btnAgregar = driver.findElement(By.xpath("/html/body/div/div/form/button"));
		inputName.sendKeys("Matias");
		inputPhone.sendKeys("123456789");
		inputMail.sendKeys("matias@solera.com");
		Thread.sleep(2000);
		btnAgregar.click();
	}

	public static void pruebaDeAgregarCliente() throws Exception{
		WebElement btnClientes = driver.findElement(By.xpath("/html/body/div/div/header/nav/ul/li[3]/button"));
		btnClientes.click();

		Thread.sleep(1000);

		WebElement btnAddClientes = driver.findElement(By.xpath("/html/body/div/div/div/button"));
		btnAddClientes.click();

		Thread.sleep(1000);

		WebElement selector = driver.findElement(By.xpath("/html/body/div/div/form/select"));
		WebElement inputClaveFiscal = driver.findElement(By.xpath("/html/body/div/div/form/input"));
		Select selection = new Select(selector);
		selection.selectByVisibleText("Matias");
		inputClaveFiscal.sendKeys("123456789");


		Thread.sleep(1000);

		WebElement btnIngresarCliente = driver.findElement(By.xpath("/html/body/div/div/form/button"));
		btnIngresarCliente.click();
	}

	public static void pruebaDeBorrarOportunidad() throws Exception{
		WebElement btnOportunidades = driver.findElement(By.xpath("/html/body/div/div/header/nav/ul/li[2]/button"));
		btnOportunidades.click();

		Thread.sleep(1000);

		WebElement btnBorrarOportunidad = driver.findElement(By.xpath("/html/body/div/div/main/div/table/tbody/tr[1]/td[4]/button"));
		btnBorrarOportunidad.click();
	}

	public static void pruebaDeBorrarClientes() throws Exception{
		WebElement btnBorrarCliente = driver.findElement(By.xpath("/html/body/div/div/main/div/table/tbody/tr[1]/td[5]/button"));
		btnBorrarCliente.click();
	}

	public static void pruebaDeVerOportunidad() throws Exception{
		WebElement btnOportunidades = driver.findElement(By.xpath("/html/body/div/div/header/nav/ul/li[2]/button"));
		btnOportunidades.click();

		Thread.sleep(1000);

		WebElement btnVerCliente = driver.findElement(By.xpath("/html/body/div/div/main/div/table/tbody/tr/td[5]/button"));
		btnVerCliente.click();

		Thread.sleep(1000);

		WebElement btnVerContactos = driver.findElement(By.xpath("/html/body/div/div/main/div[1]/table/tbody/tr[5]/td[2]/button"));
		btnVerContactos.click();

	}

	public static void pruebaDeVerCliente() throws Exception{
		WebElement btnClientes = driver.findElement(By.xpath("/html/body/div/div/header/nav/ul/li[3]/button"));
		btnClientes.click();

		Thread.sleep(1000);

		WebElement btnVerCliente = driver.findElement(By.xpath("/html/body/div/div/main/div/table/tbody/tr[1]/td[6]/button"));
		btnVerCliente.click();

		Thread.sleep(1000);

		WebElement btnVerContactos = driver.findElement(By.xpath("/html/body/div/div/main/div[1]/table/tbody/tr[5]/td[2]/button"));
		btnVerContactos.click();
	}

	public static void pruebaDeAgregarContacto() throws Exception{
		WebElement btnContactos = driver.findElement(By.xpath("/html/body/div/div/header/nav/ul/li[4]/button"));
		btnContactos.click();

		Thread.sleep(1000);

		WebElement btnAddContactos = driver.findElement(By.xpath("/html/body/div/div/div/button"));
		btnAddContactos.click();

		WebElement selector = driver.findElement(By.xpath("/html/body/div/div/form/select[2]"));
		WebElement textArea = driver.findElement(By.xpath("/html/body/div/div/form/textarea"));
		WebElement calendar = driver.findElement(By.xpath("/html/body/div/div/form/input"));
		WebElement btnEnviar = driver.findElement(By.xpath("/html/body/div/div/form/button"));

		Select selection = new Select(selector);
		selection.selectByVisibleText("Correo");
		textArea.sendKeys("El contacto fue exitoso. La oportunidad debe ser pasada a cliente");
		calendar.sendKeys("02122022");
		btnEnviar.click();
	}

	public static void pruebaDeBorrarContactos() throws Exception{
		WebElement btnBorrarCliente = driver.findElement(By.xpath("/html/body/div/div/main/div/table/tbody/tr/td[5]/button"));
		btnBorrarCliente.click();
	}
}
