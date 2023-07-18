package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QA_Exam {
    public static void main(String[] args) throws InterruptedException {
        //setup chrome driver
        WebDriverManager.chromedriver().setup();
        //define chrome driver
        WebDriver driver = new ChromeDriver();

        //navigate to site
        driver.navigate().to("https://www.gamesforthebrain.com/game/checkers/");

        //sleep
        Thread.sleep(2000);

        //make move #1
        driver.findElement(By.xpath("//*[@name='space22']")).click();
        driver.findElement(By.xpath("//*[@name='space33']")).click();

        //allow opposing move
        Thread.sleep(3000);

        //make 2nd move
        driver.findElement(By.xpath("//*[@name='space02']")).click();
        driver.findElement(By.xpath("//*[@name='space13']")).click();

        //sleep to allow opposing move
        Thread.sleep(3000);

        //make 3rd move and secure blue piece
        driver.findElement(By.xpath("//*[@name='space31']")).click();
        driver.findElement(By.xpath("//*[@name='space13']")).click();

        //allow opposing move
        Thread.sleep(3000);

        //make 4th move
        driver.findElement(By.xpath("//*[@name='space13']")).click();
        driver.findElement(By.xpath("//*[@name='space24']")).click();

        //allow opposing move
        Thread.sleep(3000);

        //make 5th move secure 2nd blue piece
        driver.findElement(By.xpath("//*[@name='space11']")).click();
        driver.findElement(By.xpath("//*[@name='space33']")).click();

        //give some time after opposing move
        Thread.sleep(2000);

        //restart the game
        driver.findElement(By.linkText("Restart...")).click();

        //give a few seconds
        Thread.sleep(2000);

        //quit session
        driver.quit();


    }//end of main
}//end of class
