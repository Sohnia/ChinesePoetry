package cn.com.sohnia.chinesepoetry;

import cn.com.sohnia.chinesepoetry.utils.FileUtils;

public class Constant {
    /**
     * 网络请求
     */
    public static final String HTTP_HEAD = "https:";

    public static final String BASE_URL = "https://www.gushiwen.org";

    public static final String BASE_URL_JUZIMI = "https://www.juzimi.com";
    /**
     * fragment
     */

    public static final String FRAGMENT_TITLE = "fragment_title";
    public static final int DAY_TIME = 0;


    /**
     *Description: 图片加载相关
     */

    public static long MB = 1024 * 1024;

    public static String CachePath = "linesImageCache";
    public static String SPLIT = "•";
    public static String SAVE_CARD_PATH = FileUtils.getCardDir();
    public static String SAVE_DIALOGUE_PATH = FileUtils.getDialogueDir();

    /**
     *登陆相关
     */
    // 开启登陆中弹窗
    public static int START_LOGIN_DIALOG = 0;
    // 关闭登陆中弹窗
    public static int CLOSE_LOGIN_DIALOG = 1;

    /**
     *Description: 分享相关
     */
    public static final int SHARE_SELECT = 0;
    public static final String LOGIN_REGISTER_URL = "https://so.gushiwen.org/user/register.aspx";
    public static final String LOGIN_SUCCEED = "https://so.gushiwen.org/user/collect.aspx";
    public static final String USER_STATE = "user_state";
    public static final String SAVE_IS_LOGINED = "save_is_logined";
    public static final String SAVE_USER_ID = "save_user_id";
    public static final String COOKIE_INTERCEPTOR_KEY = "login_cookie";
    public static final String USER_NAME = "user_name";
    public static final String SAVE_USER_NAME = "save_user_name";
    public static final int THEME_DEFAULT = 0;
    public static final int TRANSPARENT = 1;
    public static final String WIDGET_THEME = "widget_theme";
    public static final String WIDGET_THEME_TYPE = "widget_time_type";
    public static boolean IS_LOGINED = false;
    public static String USER_ID = "";

}
