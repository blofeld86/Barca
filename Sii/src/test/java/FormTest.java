
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest extends BaseTest
{
    Random raz = new Random();

    public int randomize(int i)
    {
        int rd = raz.nextInt(i);
        System.out.println("Randomed number " + rd);
        return rd;
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Jan");
        WebElement secondName = driver.findElement(By.name("lastname"));
        secondName.sendKeys("Pacino");
        //List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[id*='sex'"));

       //LATA DOŚWIADCZENIA
        List<WebElement> checkboxes = driver.findElements(By.name("sex"));
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected());

        int i = raz.nextInt(6);

        List<WebElement> barca = driver.findElements(By.name("exp"));

        barca.get(i).click();
        Assert.assertTrue(barca.get(i).isSelected());

        WebElement uploadPhoto = driver.findElement(By.id("photo"));

        File photo = new File("src\\Files\\xyz.jpg");
        String absolutePathToPhoto = photo.getAbsolutePath();
        System.out.println("absolut path: " + absolutePathToPhoto);
        uploadPhoto.sendKeys(absolutePathToPhoto);

        WebElement countryList = driver.findElement(By.id("continents"));
        Select countrySelect = new Select(countryList);
        int numberOfOptions = countrySelect.getOptions().size();


        //POBRANIE ILOśCI DOSTĘPNYCH OPCJI
        i = raz.nextInt(countrySelect.getOptions().size()-1);

        //countrySelect.selectByVisibleText("Europe");

        //KLIKNIĘCIE LOSOWEJ OPCJI

        countrySelect.selectByIndex(i);
        //countrySelect.selectByValue("");


        //3 SEKUNDY
        Thread.sleep(3000);


    }

}
