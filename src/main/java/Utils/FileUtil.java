package Utils;

import java.io.File;

/**
 * 处理文件工具
 */
public class FileUtil {

    private volatile static FileUtil fileUtil;

    public synchronized static FileUtil instance() {
        if (fileUtil == null) {
            fileUtil = new FileUtil();
        }
        return fileUtil;
    }

    public FileUtil() {
    }

    /**
     * 主要是打印提示
     *
     * @param path 地址
     * @return Boolean
     */
    public boolean isExists(String path) {
        File file = new File(path);
        if (file.exists()) {
            System.out.println("文件存在");
            return true;
        } else {
            System.out.println("地址错误");
            return false;
        }
    }
}
