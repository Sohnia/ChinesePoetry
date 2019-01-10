package cn.com.sohnia.chinesepoetry.ui.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.ui.base.BasePresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IMainActivity;
import cn.com.sohnia.chinesepoetry.utils.PermissionReq;
import cn.com.sohnia.chinesepoetry.utils.ToastUtils;

public class MainActivityPresenter extends BasePresenter<IMainActivity> {
    private IMainActivity iMainAcitivity;
    private Context context;
    public MainActivityPresenter(Context context) {
        this.context = context;
    }

    public void getStoragePremission(){
        PermissionReq.with((Activity)context)
                .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .result(new PermissionReq.Result() {
                    @Override
                    public void onGranted() {
                    }

                    @Override
                    public void onDenied() {
                        ToastUtils.show(R.string.no_permission_storage);
                    }
                })
                .request();
    }
}
