package CycleOperation.Activity;


import Bean.Account;
import CycleOperation.BaseProcess;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * LoginActivity
 */
public class LoginA extends BaseProcess {

    private Account account;

    public LoginA(AndroidDriver driver, Account account) {
        super(driver);
        this.account = account;
    }

    public void beginning() {

    }

    public void stop() {

    }

    public void finish() {

    }

    @Override
    public void inspect() {

        //账号密码登录
        driver.findElement(By.id("com.groupds.android:id/ed_phone")).sendKeys(account.getAccount());
        driver.findElement(By.id("com.groupds.android:id/ed_code")).sendKeys(account.getPassword());
        driver.findElement(By.id("com.groupds.android:id/login")).click();
    }

    public void allElement() {

    }
}
