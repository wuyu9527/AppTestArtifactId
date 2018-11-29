package CycleOperation.Fragment;

import CycleOperation.BaseProcess;
import Utils.Util;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ConsultationFragment extends BaseProcess {

    public ConsultationFragment(AndroidDriver driver) {
        super(driver);
    }

    public void beginning() {

    }

    public void stop() {

    }

    public void finish() {

    }

    @Override
    public void inspect() {
        Util.instance().sleep(5);
        //会诊病人点击和列表点击 第一个
        WebElement webElement = driver.findElement(MobileBy.AccessibilityId("com.groupds.android:id/rvTitle"));
        if (webElement.isDisplayed()) {
            List<WebElement> webElements = webElement.findElements(By.id("com.groupds.android:id/tvName"));
            if (webElements.size()>0) {
                webElements.get(webElements.size() - 1).click();
                List<WebElement> webElementList = driver.findElementById("com.groupds.android:id/recyclerView")
                        .findElements(By.className("android.widget.LinearLayout"));
                Util.instance().sleep(5);
                System.out.println(webElementList.size());
                webElementList.get(0).click();
            }
        }




        //Util.instance().sleep(5);
        //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]").click();

    }

    public void allElement() {

    }
}
