package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // navegar por una url
    public static void navigateTo(String url) {
        driver.get(url);
    }

    // cerrar navegador
    public static void closeBrowser() {
        driver.quit();
    }

    // encontrar un elemento web
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    // dar click
    public void clickElement(String locator) {
        Find(locator).click();
    }

    // escribir texto
    public void write(String locator, String textToWrite) {
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    // menu desplegable - se busca por el valor
    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }
    // menu desplegable - se busca por el index
    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }
    // menu desplegable - se busca por el texto
    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    // hover over (mover el mouse por la pantalla)
    public void hoverOverElement(String locator) {
        action.moveToElement(Find(locator));
    }

    // doble click
    public void doubleClick(String locator) {
        action.doubleClick(Find(locator));
    }

    // click derecho
    public void rightClick(String locator) {
        action.contextClick(Find(locator));
    }

    // obtener datos de una tabla estatica
    public String getValueOfTables(String locator, int row, int column) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        return Find(cellINeed).getText();
    }

    // llamar los datos
    public void setValueOfTable(String locator, int row, int column, String stringToSend) {
        String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        Find(cellToFill).sendKeys(stringToSend);
    }

    // IFrame
    public void switchToiFrame(String iFrameIndex) {
        driver.switchTo().frame(iFrameIndex);
    }

    // IFrame
    public void switchToParentFrame(String iFrameIndex) {
        driver.switchTo().parentFrame();
    }

    // pop up (alerta)
    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    // validar texto
    public String textFromElement(String locator) {
        return Find(locator).getText();
    }

    // elementos habilitados para clickear
    public boolean elementEnabled(String locator) {
        return Find(locator).isEnabled();
    }

    // elementos visibles
    public boolean elementIsDisplayed(String locator) {
        return Find(locator).isDisplayed();
    }

    // si esta seleccionado o no
    public boolean elementIsSelected(String locator) {
        return Find(locator).isSelected();
    }

    // lista de elementos
    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.className(locator));
    }
}
