package cn.com.sohnia.chinesepoetry.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.ui.base.BaseFragment;
import cn.com.sohnia.chinesepoetry.ui.presenter.HomeSentenceFragmentPresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IHomeSentenceFragment;

public class HomeSentenceFragment extends
        BaseFragment<IHomeSentenceFragment,HomeSentenceFragmentPresenter> {
    @Override
    protected HomeSentenceFragmentPresenter createPresenter() {
        return new HomeSentenceFragmentPresenter(getContext());
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_home_commend;
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
