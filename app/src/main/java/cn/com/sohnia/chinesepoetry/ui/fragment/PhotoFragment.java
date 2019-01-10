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
import cn.com.sohnia.chinesepoetry.adapter.DialogueAdapter;
import cn.com.sohnia.chinesepoetry.info.DialogueInfo;
import cn.com.sohnia.chinesepoetry.ui.base.BaseFragment;
import cn.com.sohnia.chinesepoetry.ui.presenter.PhotoFragmentPresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IPhotoFragment;
import cn.com.sohnia.chinesepoetry.utils.ImageUtil.ImageLoader;

public class PhotoFragment extends BaseFragment<IPhotoFragment,PhotoFragmentPresenter> implements IPhotoFragment {
    @BindView(R.id.fragment_photo_rcy)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.fragment_photo_error)
    RelativeLayout errorLayout;
    private DialogueAdapter dialogueAdapter;

    @Override
    protected PhotoFragmentPresenter createPresenter() {
        return new PhotoFragmentPresenter(getContext());
    }
    @Override
    protected void initView(View rootView) {
        swipeRefreshLayout.setRefreshing(true);
        dialogueAdapter = new DialogueAdapter(new ArrayList<>());
        dialogueAdapter.setHeaderAndEmpty(true);
        dialogueAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        dialogueAdapter.setEnableLoadMore(false);
        recyclerView.setAdapter(dialogueAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_photo;
    }

    @Override
    protected void initData() {
        mPresenter.pullToRefresh(false);
    }

    @Override
    protected void initViewListener() {
        swipeRefreshLayout.setOnRefreshListener(() -> mPresenter.pullToRefresh(false));
        dialogueAdapter.setOnLoadMoreListener(() -> mPresenter.pullToRefresh(true));
        dialogueAdapter.setOnItemLongClickListener((adapter, view, position) -> {
            DialogueInfo.DialogueItem item = (DialogueInfo.DialogueItem) adapter.getItem(position);
            String url = item.getmDialogueItemUrl();
            ImageLoader.getBitmapByUrl(getContext(), url);
            return true;
        });
        dialogueAdapter.setOnItemClickListener((adapter, view, position) -> {
//            Bundle bundle = new Bundle();
//            DialogueInfo.DialogueItem item = (DialogueInfo.DialogueItem) adapter.getItem(position);
//            String photoUrl = item.getmDialogueItemUrl();
//            bundle.putString(ExplorePhotoActivity.EXPLORE_PHOTO_KEY, photoUrl);
//            ExplorePhotoActivity.startActivity(getContext(), bundle);
        });
        errorLayout.setOnClickListener(view -> {
            swipeRefreshLayout.setRefreshing(true);
            mPresenter.pullToRefresh(false);
            errorLayout.setVisibility(View.GONE);
        });
    }

    @Override
    public RelativeLayout getErrorLayout() {
        return errorLayout;
    }

    @Override
    public SwipeRefreshLayout getSwipeSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }

    @Override
    public DialogueAdapter getAdapter() {
        return dialogueAdapter;
    }
}
