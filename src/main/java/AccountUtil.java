import Bean.Account;
import MyExcel.ExcelReader;
import org.apache.http.util.TextUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class AccountUtil {

    private boolean getAccounts = false;
    private List<Account> accounts;

    private volatile static AccountUtil accountUtil;

    synchronized static AccountUtil instance() {
        if (accountUtil == null) {
            accountUtil = new AccountUtil();
        }
        return accountUtil;
    }

    private AccountUtil() {
        accounts = new ArrayList<Account>();
    }

    boolean isGetAccounts() {
        return getAccounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * @param accountFile 账号密码表格
     */
    AccountUtil accountUtil(String accountFile) {
        File file = new File(accountFile);
        if (!file.exists()) {
            System.out.println("文件地址错误或不存在");
            getAccounts = false;
            return accountUtil;
        }

        ExcelReader excelReader = new ExcelReader();
        try {
            accounts = excelReader.readXls(file);
        } catch (Exception e) {
            e.printStackTrace();
            getAccounts = false;
            return accountUtil;
        }
        if (accounts == null) {
            System.out.println("未从表格获取到账号");
            getAccounts = false;
            return accountUtil;
        }
        List<Account> accountsIsEmpty = new ArrayList<Account>();
        for (Account account : accounts) {
            if (TextUtils.isEmpty(account.getAccount()) || TextUtils.isEmpty(account.getPassword())) {
                accountsIsEmpty.add(account);
            }
        }
        accounts.removeAll(accountsIsEmpty);
        if (accounts.size() == 0) {
            System.out.println("账号或密码是空的");
            getAccounts = false;
            return accountUtil;
        }
        getAccounts = true;
        return accountUtil;
    }
}
