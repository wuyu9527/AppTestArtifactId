package CycleOperation;

import Bean.Account;
import io.appium.java_client.android.AndroidDriver;

/**
 * 流程
 */
public class CycleOperation {

    private AndroidDriver driver;
    private Account account;

    public CycleOperation(AndroidDriver driver, Account account) {
        this.driver = driver;
        this.account = account;
    }

    /**
     * 单个页面所有可动的流程
     */
    public void singleProcess() {
        new Thread(new Runnable() {
            public void run() {

            }
        }).start();
    }

    /**
     * 全部流程和功能点击
     */
    public void wholeProcess() {
        new Thread(new Runnable() {
            public void run() {
                SlideScreen slideScreen =new SlideScreen(driver);
                slideScreen.slideLeft();
                slideScreen.slideLeft();
                slideScreen.slideLeft();
                driver.findElementById("com.groupds.android:id/button").click();
                IFactory factory = new CycleFactory(driver,account);
                factory.getProcess("LoginA").inspect();
                factory.getProcess("ConsultationFragment").inspect();
                factory.getProcess("InTheConsultationActivity").inspect();
            }
        }).start();

    }






}
