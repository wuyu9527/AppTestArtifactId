import Utils.FileUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Devices {

    private Map<String, DesiredCapabilities> devicesMap;
    private List<DesiredCapabilities> devices;
    private String appPath;

    public Devices(String appPath) {
        this.appPath = appPath;
        devices = new ArrayList<DesiredCapabilities>();
        devicesMap = new HashMap<String, DesiredCapabilities>();
        if (FileUtil.instance().isExists(appPath)) {
            //getDesiredCapabilitiesAndroid8();
            getDesiredCapabilitiesAndroid7();
        }
    }

    public Map<String, DesiredCapabilities> getDevicesMap() {
        return devicesMap;
    }

    public List<DesiredCapabilities> getDevices() {
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
    private void getDesiredCapabilitiesAndroid8() {
        System.out.println("8.0:192.168.249.101:5555");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("app", appPath);
        capabilities.setCapability("appPackage", "com.groupds.android");
        capabilities.setCapability("appActivity", "com.groupds.android.mvp.ui.activity.LoginActivity");
        capabilities.setCapability("deviceName", "192.168.249.101:5555");
        capabilities.setCapability("autoGrantPermissions", true);
        //capabilities.setCapability("automationName", "Appium");
        devices.add(capabilities);
        devicesMap.put("8.0", capabilities);
    }

    /**
     * {
     * "platformName": "Android",
     * "platformVersion": "7.1.2",
     * "app": "C:\\Users\\gupo-android\\Desktop\\APP\\release\\app-release.apk",
     * "appPackage": "com.groupds.android",
     * "appActivity": "com.groupds.android.mvp.ui.activity.LoginActivity",
     * "autoGrantPermissions": true,
     * "deviceName": "127.0.0.1:62026"
     * }
     */
    private void getDesiredCapabilitiesAndroid7(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.1.2");
        capabilities.setCapability("app", appPath);
        capabilities.setCapability("appPackage", "com.groupds.android");
        capabilities.setCapability("appActivity", "com.groupds.android.mvp.ui.activity.SplashActivity");
        capabilities.setCapability("deviceName", "192.168.249.2:62025");
        capabilities.setCapability("autoGrantPermissions", true);
        //capabilities.setCapability("automationName", "Appium");
        devices.add(capabilities);
        devicesMap.put("7.1.2", capabilities);
    }

}
