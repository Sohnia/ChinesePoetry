package cn.com.sohnia.chinesepoetry.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import java.util.HashSet;
import java.util.Set;

import cn.com.sohnia.chinesepoetry.storage.preference.Preferences;
import cn.com.sohnia.chinesepoetry.utils.ToastUtils;
import io.objectbox.BoxStore;
import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;


public class BaseApplication extends Application {
    private static Set<Activity> allActivities;
    private static Context mInstance;
    public static Context getInstance() {
        return mInstance;
    }
    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        //crash报告
        CrashHandler.getInstance().init();
        //toast工具
        ToastUtils.init(this);
        Preferences.init(getApplicationContext());
        SkinCompatManager.withoutActivity(this)                         // 基础控件换肤初始化
                .addInflater(new SkinMaterialViewInflater())            // material design 控件换肤初始化[可选]
                .addInflater(new SkinConstraintViewInflater())          // ConstraintLayout 控件换肤初始化[可选]
                .addInflater(new SkinCardViewInflater())                // CardView v7 控件换肤初始化[可选]
                .setSkinStatusBarColorEnable(false)                     // 关闭状态栏换肤，默认打开[可选]
                .setSkinAllActivityEnable(false)
                .setSkinWindowBackgroundEnable(true)                   // 关闭windowBackground换肤，默认打开[可选]
                .loadSkin();
        //调试工具
        Stetho.initializeWithDefaults(this);
        //objectbox
//        boxStore = MyObjectBox.builder().androidContext(BaseApplication.this).build();
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }

    public static void registerActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<Activity>();
        }
        allActivities.add(act);
    }

    public static void unregisterActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public static void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    if (act != null && !act.isFinishing())
                        act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
