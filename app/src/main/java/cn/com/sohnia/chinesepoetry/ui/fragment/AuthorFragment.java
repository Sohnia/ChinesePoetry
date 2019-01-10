package cn.com.sohnia.chinesepoetry.ui.fragment;

import android.view.View;

import butterknife.ButterKnife;
import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.ui.base.BaseFragment;
import cn.com.sohnia.chinesepoetry.ui.presenter.AuthorFragmentPresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IAuthorFragment;

public class AuthorFragment extends BaseFragment<IAuthorFragment,AuthorFragmentPresenter> {
    @Override
    protected AuthorFragmentPresenter createPresenter() {
        return new AuthorFragmentPresenter(getContext());
    }
    @Override
    protected void initView(View rootView) {
        ButterKnife.bind(this, rootView);
    }
    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_author;
    }
}
