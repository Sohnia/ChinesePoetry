package cn.com.sohnia.chinesepoetry.storage.preference;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import java.util.HashSet;

import cn.com.sohnia.chinesepoetry.Constant;

public class Preferences {
    private static Context sContext;
    public static void init(Context context) {
        sContext = context.getApplicationContext();
    }

    private static final String USE_AGREEMENT = "resourceSuffix";
    private static final String SAVE_IS_LOGINED = "save_is_logined";
    private static final String SAVE_USER_ID = "save_user_id";
    private static final String COOKIE_INTERCEPTOR_KEY = "login_cookie";
    private static final String CURRENT_DATA = "current_data";
    private static final String COMMEND_FRAGMENT_PAGE = "commend_fragment_page";

    public static int getCommendFragmentPage(){return getInt(COMMEND_FRAGMENT_PAGE,1);}
    public static void setCommendFragmentPage(int commendFragmentPage){saveInt(COMMEND_FRAGMENT_PAGE,commendFragmentPage);}

    public static String getCurrentData(){ return getString(CURRENT_DATA,""); }
    public static void  setCurrentData(String currentData){saveString(CURRENT_DATA,currentData);}

    public static String getResourceSuffix(){return getString(USE_AGREEMENT,"default");}
    public static void setResourceSuffix(String b){saveString(USE_AGREEMENT,b);}

    public static boolean getSaveIsLogined(){return getBoolean(SAVE_IS_LOGINED,false);}
    public static void    setSaveIsLogined(boolean flag){saveBoolean(SAVE_IS_LOGINED,flag);}

    public static String getSaveUserId() {
        return getString(SAVE_USER_ID,"");
    }

    public static void setSaveUserId(String saveUserId){
        getString(SAVE_USER_ID,saveUserId);
    }
    public static HashSet<String> getCookieInterceptorKey() {
        return (HashSet) getPreferences().getStringSet(Constant.COOKIE_INTERCEPTOR_KEY, new HashSet<>());
    }
    public static void setCookieInterceptorKey(HashSet<String> cookies){
        getPreferences().edit().putStringSet(Constant.COOKIE_INTERCEPTOR_KEY, cookies).apply();
    }

    private static boolean getBoolean(String key, boolean defValue) {
        return getPreferences().getBoolean(key, defValue);
    }

    private static void saveBoolean(String key, boolean value) {
        getPreferences().edit().putBoolean(key, value).apply();
    }

    private static int getInt(String key, int defValue) {
        return getPreferences().getInt(key, defValue);
    }

    private static void saveInt(String key, int value) {
        getPreferences().edit().putInt(key, value).apply();
    }

    private static long getLong(String key, long defValue) {
        return getPreferences().getLong(key, defValue);
    }

    private static void saveLong(String key, long value) {
        getPreferences().edit().putLong(key, value).apply();
    }

    private static String getString(String key, @Nullable String defValue) {
        return getPreferences().getString(key, defValue);
    }

    private static void saveString(String key, @Nullable String value) {
        getPreferences().edit().putString(key, value).apply();
    }
    public static void recieverSave(String key,String value){
        getPreferences().edit().putString(key, value).apply();
    }

    private static SharedPreferences getPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(sContext);
    }
}
