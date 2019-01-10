package cn.com.sohnia.chinesepoetry.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.adapter.PoetryItemAdapter;
import cn.com.sohnia.chinesepoetry.storage.preference.Preferences;
import cn.com.sohnia.chinesepoetry.ui.base.BaseFragment;
import cn.com.sohnia.chinesepoetry.ui.presenter.HomeCommendFragmentPresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IHomeCommendFragment;

public class HomeCommedFragment extends
        BaseFragment<IHomeCommendFragment,HomeCommendFragmentPresenter>
        implements IHomeCommendFragment {

    @BindView(R.id.fragment_rcy)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.fragment_home_error)
    RelativeLayout errorLayout;
    private PoetryItemAdapter poetryItemAdapter;


    @Override
    protected HomeCommendFragmentPresenter createPresenter() {
        return new HomeCommendFragmentPresenter(getContext());
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_home_commend;
    }

    @Override
    protected void initData() {
        mPresenter.pullToRefresh(false);
    }

    @Override
    protected void initViewListener() {
        swipeRefreshLayout.setOnRefreshListener(() -> mPresenter.pullToRefresh(false));
        poetryItemAdapter.setOnLoadMoreListener(() -> mPresenter.pullToRefresh(true));
        poetryItemAdapter.setOnItemClickListener((adapter, view, position) -> {
//            TODO
            //            SearchInfo.SentencesItem sentencesItem = (SearchInfo.SentencesItem) adapter.getItem(position);
//            sentencesItem = SentenceUtil.completeSentence(sentencesItem);
//
//            Bundle bundle = new Bundle();
//            bundle.putParcelable(Constant.SHARE_INFO, sentencesItem);
//
//            ShareActivity.startActivity(getActivity(), bundle);
        });
        errorLayout.setOnClickListener(view -> {
            swipeRefreshLayout.setRefreshing(true);
            mPresenter.pullToRefresh(false);
            errorLayout.setVisibility(View.GONE);
        });
    }

    @Override
    protected void initView(View rootView) {
        poetryItemAdapter = new PoetryItemAdapter(new ArrayList<>());
        poetryItemAdapter.setHeaderAndEmpty(true);
        poetryItemAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        poetryItemAdapter.setEnableLoadMore(false);
        recyclerView.setAdapter(poetryItemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public PoetryItemAdapter getAdapter() {
        return poetryItemAdapter;
    }

    @Override
    public SwipeRefreshLayout getSwipeSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }

    @Override
    public RelativeLayout getErrorLayout() {
        return errorLayout;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Preferences.setCommendFragmentPage(mPresenter.getmCurrentPage());
    }
}
