package cn.com.sohnia.chinesepoetry.ui.presenter;

import android.content.Context;

import cn.com.sohnia.chinesepoetry.ui.base.BasePresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IMineFragment;

public class MineFragmentPresenter extends BasePresenter<IMineFragment> {
    private Context context;
    private IMineFragment iMineFragment;

    public MineFragmentPresenter(Context context) {
        this.context = context;
    }
}
