import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class Devices {

    private Map<String, DesiredCapabilities> devices;

    public Devices() {
        devices = new HashMap<String, DesiredCapabilities>();
        devices.put("8.0", getDesiredCapabilitiesAndroid8());
    }

    public Map<String, DesiredCapabilities> getDevices() {
        return devices;
    }

    /**
     * {
     * "platformName": "Android",
     * "platformVersion": "8.0",
     * "app": "C:\\Users\\gupo-android\\Desktop\\APP\\release\\app-release.apk",
     * "appPackage": "com.groupds.android",
     * "appActivity": "com.groupds.android.mvp.ui.activity.LoginActivity",
     * "autoGrantPermissions": true,
     * "deviceName": "192.168.249.101:5555"
     * }
     */
    private DesiredCapabilities getDesiredCapabilitiesAndroid8() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("app", "C:\\Users\\gupo-android\\Desktop\\APP\\release\\app-release.apk");
        capabilities.setCapability("appPackage", "com.groupds.android");
        capabilities.setCapability("appActivity", "com.groupds.android.mvp.ui.activity.LoginActivity");
        capabilities.setCapability("deviceName", "192.168.249.101:5555");
        capabilities.setCapability("autoGrantPermissions", true);
        //capabilities.setCapability("automationName", "Appium");
        return capabilities;
    }
}
