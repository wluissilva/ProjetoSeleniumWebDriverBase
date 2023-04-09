package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commands extends Utils{

    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //Metodo Criado para clicar nos elementos
    public static void clickElement(By element) {

        System.out.println("######################################################");
        try{
            System.out.println("****** Vai clicar no elemento " +element + "******");
            waitElementBeClickable(element, 2000);
            getDriver().findElement(element).click();
            System.out.println("****** Clicou no elemento " +element + "******");

        }catch (Exception error){
            System.out.println("****** Ocorreu um erro ao tentar clicar no elemento " +element + "******");
            System.out.println(error);
        }
        System.out.println("######################################################");
    }

    //Metodo Criado para Preencher campos
    public static void fillField(By element, String value) {

        System.out.println("######################################################");
        try{
            System.out.println("****** Vai preencher o campo " +element + "******");
            waitElementBeVisible(element, 2000);
            getDriver().findElement(element).sendKeys(value);
            System.out.println("****** Preencheu o campo " +element + "******");
        }catch (Exception error){
            System.out.println("****** Ocorreu um erro ao tentar preencher o campo " +element + "******");
            System.out.println(error);
        }
        System.out.println("######################################################");

    }

    //Metodo criado para validar mensagens
    public static void checkMessage(By element, String expectedMessage){

        String actualMessage = "";

        try{
            System.out.println("######################################################");
            waitElementBePresent(element, 2000);
            System.out.println("Vai validar mensagem "+ expectedMessage);
            actualMessage = getDriver().findElement(element).getText();
            Assert.assertEquals(expectedMessage, actualMessage);
            System.out.println("Validou a mensagem "+ expectedMessage);
            System.out.println("######################################################");

        } catch (Exception error){

            System.out.println(error);
        }
    }
}