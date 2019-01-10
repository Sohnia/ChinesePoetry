package cn.com.sohnia.chinesepoetry.ui.presenter;

import android.content.Context;

import cn.com.sohnia.chinesepoetry.ui.base.BasePresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IHomePoetryFragment;

public class HomePoetryFragmentPresenter extends BasePresenter<IHomePoetryFragment> {
    private IHomePoetryFragment iHomePoetryFragment;
    private Context context;

    public HomePoetryFragmentPresenter(Context context) {
        this.context = context;
    }
}
