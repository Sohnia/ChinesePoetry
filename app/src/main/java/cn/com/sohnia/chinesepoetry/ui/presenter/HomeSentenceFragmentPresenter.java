package cn.com.sohnia.chinesepoetry.ui.presenter;

import android.content.Context;

import cn.com.sohnia.chinesepoetry.ui.base.BasePresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IHomeSentenceFragment;

public class HomeSentenceFragmentPresenter extends BasePresenter<IHomeSentenceFragment> {
    private IHomeSentenceFragment iHomeSentenceFragment;
    private Context context;

    public HomeSentenceFragmentPresenter(Context context) {
        this.context = context;
    }
}
