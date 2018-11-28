import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Test {


    /**
     * 点击 driver.findElement(By.name("1")).click();
     * 文本 driver.findElement(By.id("com.android.calculator2:id/formula")).getText()
     * 输入 driver.findElement(By.id("com.groupds.android:id/ed_phone")).sendKeys("1");
     */
    public static void main(String[] args)  {

        Devices devices = new Devices();

        DesiredCapabilities capabilities = devices.getDevices().get("8.0");
        AndroidDriver driver;
        try {
             driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }catch (Exception e){
            e.printStackTrace();
            return;
        }



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("com.groupds.android:id/ed_phone")).sendKeys("1");

        String phone = driver.findElement(By.id("com.groupds.android:id/ed_phone")).getText();
        System.out.println(phone);

        driver.quit();
    }


}
