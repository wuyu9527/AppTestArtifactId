package CycleOperation.Activity;

import CycleOperation.BaseProcess;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CasesActivity extends BaseProcess {

    public CasesActivity(AndroidDriver driver) {
        super(driver);
    }

    public void beginning() {

    }

    public void stop() {

    }

    public void finish() {

    }

    public void allElement() {

    }

    @Override
    public void inspect() {

        List<WebElement> elements = driver.findElements(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout"));

        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

    }
}
