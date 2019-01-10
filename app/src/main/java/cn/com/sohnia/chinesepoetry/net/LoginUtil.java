package cn.com.sohnia.chinesepoetry.net;

import java.util.HashSet;

import cn.com.sohnia.chinesepoetry.Constant;
import cn.com.sohnia.chinesepoetry.storage.preference.Preferences;


public class LoginUtil {

    public static void initLoginState() {
        boolean isLogin = Preferences.getSaveIsLogined();
        if (isLogin) {
            //如果已经登陆过更新本地状态
            Constant.IS_LOGINED = true;
            Constant.USER_ID = Preferences.getSaveUserId();
        }
    }

    /**
     *退出登录
     */
    public static void loginOut() {
        if (Preferences.getCookieInterceptorKey() != null) {
            Preferences.setCookieInterceptorKey(new HashSet<>());
        }
        Constant.IS_LOGINED = false;
        Constant.USER_ID = "";
        Preferences.setSaveIsLogined(false);
        Preferences.setSaveUserId("");
    }

}
