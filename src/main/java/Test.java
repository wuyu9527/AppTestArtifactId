import Bean.Account;
import CycleOperation.CycleOperation;
import Utils.Util;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Test {


    /**
     * 点击 driver.findElement(By.name("1")).click();
     * 文本 driver.findElement(By.id("com.android.calculator2:id/formula")).getText()
     * 输入 driver.findElement(By.id("com.groupds.android:id/ed_phone")).sendKeys("1");
     * RecyclerView或list 子元素获取
     *      List<WebElement> webElements = driver
     *      .findElementById("com.groupds.android:id/rvTitle")
     *      .findElements(By.id("com.groupds.android:id/tvName"));
     */
    public static void main(String[] args) {
        String accountFile = "C:\\Users\\gupo-android\\Desktop\\账号.xlsx";
        String appPath = "C:\\Users\\gupo-android\\Desktop\\APP\\Gds1.5.1.apk";
        AccountUtil.instance().accountUtil(accountFile);
        if (!AccountUtil.instance().isGetAccounts()) {
            return;
        }

        List<Account> account = AccountUtil.instance().getAccounts();
        Devices devices = new Devices(appPath);

        int countDevices = devices.getDevices().size();
        int num = 0;

        for (int i = 0; i < countDevices; i++) {
            if (account.size() - 1 <= num) {
                startDriver(devices.getDevices().get(i), account.get(num));
                num++;
            } else {
                num = 0;
                startDriver(devices.getDevices().get(i), account.get(num));
                num++;
            }
        }
    }


    private static void startDriver(DesiredCapabilities desiredCapabilities, Account account) {
        // DesiredCapabilities capabilities = devices.getDevicesMap().get("8.0");
        AndroidDriver driver;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }


        Util.instance().sleep(2);

        CycleOperation cycleOperation = new CycleOperation(driver, account);

        cycleOperation.wholeProcess();

    }


}
