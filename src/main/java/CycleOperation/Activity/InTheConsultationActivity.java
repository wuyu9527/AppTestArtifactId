package CycleOperation.Activity;

import CycleOperation.BaseProcess;
import Utils.Util;
import io.appium.java_client.android.AndroidDriver;

public class InTheConsultationActivity extends BaseProcess {

    public InTheConsultationActivity(AndroidDriver driver) {
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
        //进入病人病历
        driver.findElementById("com.groupds.android:id/check_cases").click();
    }
}
