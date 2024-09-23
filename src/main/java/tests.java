import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class tests {

    @Test
    public void VerifyPageTitleAndCloseWelcomeMessage(){
        WebDriver driver =Configurations.instantiate();
        assertEquals(driver.getTitle(),"Home - Cora Systems");
        WebElement iframe = driver.findElement(By.id("hubspot-conversations-iframe"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Dismiss']"))).click();
        driver.close();
    }

    @Test
    public void CheckAPIRepsonse() {
        RestAssured.baseURI = "https://corasystems.com/";
        Response response = given().when().get();
        response.then().statusCode(200);
    }
}
