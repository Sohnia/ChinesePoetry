package cn.com.sohnia.chinesepoetry.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.ui.base.BaseActivity;
import cn.com.sohnia.chinesepoetry.ui.base.BasePresenter;
import skin.support.widget.SkinCompatSupportable;

public class LoginActivity extends BaseActivity implements SkinCompatSupportable {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Override
    public void applySkin() {

    }
}
