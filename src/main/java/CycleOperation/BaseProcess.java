package CycleOperation;

import io.appium.java_client.android.AndroidDriver;

public abstract class BaseProcess {

    protected AndroidDriver driver;

    public BaseProcess(AndroidDriver driver) {
        this.driver = driver;
    }

    /**
     * 开始
     */
    public abstract void beginning();

    /**
     * 跳转其他页面,本页面未结束
     */
    public abstract void stop();

    /**
     * 本页面结束
     */
    public abstract void finish();

    /**
     * 检查页面,快速流程
     */
    public abstract void inspect();
    /**
     * 检查所有元素
     */
    public abstract void allElement();
}
