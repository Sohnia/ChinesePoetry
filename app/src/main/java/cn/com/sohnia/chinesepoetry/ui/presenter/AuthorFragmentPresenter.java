package cn.com.sohnia.chinesepoetry.ui.presenter;

import android.content.Context;

import cn.com.sohnia.chinesepoetry.ui.base.BasePresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IAuthorFragment;

public class AuthorFragmentPresenter extends BasePresenter<IAuthorFragment> {
    private IAuthorFragment iAuthorFragment;
    private Context context;

    public AuthorFragmentPresenter(Context context) {
        this.context = context;
    }
}
