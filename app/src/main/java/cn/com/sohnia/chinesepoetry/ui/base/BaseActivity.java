package cn.com.sohnia.chinesepoetry.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cn.com.sohnia.chinesepoetry.app.BaseApplication;
import cn.com.sohnia.chinesepoetry.utils.PermissionReq;
import cn.com.sohnia.chinesepoetry.utils.StatusBarUtil.StatusBarUtils;

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {
    protected T mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApplication.registerActivity(this);
        if (null != createPresenter()) {
            mPresenter = createPresenter();
            mPresenter.attachView((V) this);
        }
//        String resourceSuffix = Preferences.getResourceSuffix();
//        if("default" != resourceSuffix){
//          SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // 后缀加载
//        }else
        StatusBarUtils.setTranslucentStatus(this);
        StatusBarUtils.setImmersiveStatusBar(this,true);
        Log.d(this.getClass().getName(),  "onCreate.");
    }

    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null) {
            mPresenter.detachView();
        }
        BaseApplication.unregisterActivity(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionReq.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(this.getClass().getName() , "------>onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(this.getClass().getName(),  "------>onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(this.getClass().getName() , "------>onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(this.getClass().getName(),  "------>onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(this.getClass().getName(),  "------>onStop");
    }

}
