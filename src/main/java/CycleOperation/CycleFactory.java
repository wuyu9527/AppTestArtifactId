package CycleOperation;

import Bean.Account;
import CycleOperation.Activity.InTheConsultationActivity;
import CycleOperation.Activity.LoginA;
import CycleOperation.Fragment.ConsultationFragment;
import io.appium.java_client.android.AndroidDriver;
import org.apache.http.util.TextUtils;

public class CycleFactory implements IFactory {

    private AndroidDriver driver;
    private Account account;

    public CycleFactory(AndroidDriver driver, Account account) {
        this.driver = driver;
        this.account = account;
    }


    public BaseProcess getProcess(String name) {
        if (name.equals("LoginA")) {
            return new LoginA(driver, account);
        } else if (name.equals("ConsultationFragment")) {
            return new ConsultationFragment(driver);
        } else if (name.equals("InTheConsultationActivity")) {
            return new InTheConsultationActivity(driver);
        }
        return null;
    }


}
