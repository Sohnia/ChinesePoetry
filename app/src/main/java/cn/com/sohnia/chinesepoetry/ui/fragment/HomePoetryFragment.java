package cn.com.sohnia.chinesepoetry.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.ui.base.BaseFragment;
import cn.com.sohnia.chinesepoetry.ui.presenter.HomePoetryFragmentPresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IHomePoetryFragment;

public class HomePoetryFragment extends
        BaseFragment<IHomePoetryFragment,HomePoetryFragmentPresenter> {
    @Override
    protected HomePoetryFragmentPresenter createPresenter() {
        return new HomePoetryFragmentPresenter(getContext());
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_home_poetry;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
    }

}
