package cn.com.sohnia.chinesepoetry.ui.presenter;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.List;

import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.adapter.DialogueAdapter;
import cn.com.sohnia.chinesepoetry.adapter.PoetryItemAdapter;
import cn.com.sohnia.chinesepoetry.info.DialogueInfo;
import cn.com.sohnia.chinesepoetry.info.PoetryInfo;
import cn.com.sohnia.chinesepoetry.net.ApiServices;
import cn.com.sohnia.chinesepoetry.ui.base.BasePresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IPhotoFragment;
import cn.com.sohnia.chinesepoetry.utils.ToastUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PhotoFragmentPresenter extends BasePresenter<IPhotoFragment> {
    private Context context;
    private IPhotoFragment iPhotoFragment;
    private int mCurrentPage;
    private DialogueAdapter poetryItemAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RelativeLayout errorLayout;

    public PhotoFragmentPresenter(Context context) {
        this.context = context;
    }

    public void pullToRefresh(boolean isLoadMore) {
        mCurrentPage = isLoadMore ? ++mCurrentPage : 1;
        loadData(mCurrentPage);
    }

    public void loadData(int page){
        if (iPhotoFragment == null){
            iPhotoFragment = getView();
            errorLayout = iPhotoFragment.getErrorLayout();
            swipeRefreshLayout = iPhotoFragment.getSwipeSwipeRefreshLayout();
            poetryItemAdapter = iPhotoFragment.getAdapter();
        }
        ApiServices.getAPIs().getDialoguePage(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DialogueInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DialogueInfo dialogueInfo) {
                        if (dialogueInfo == null) {
                            ToastUtils.show(R.string.load_fail);
                        }
                        if (dialogueInfo!= null) {
                            List<DialogueInfo.DialogueItem> dialogueItems = dialogueInfo.getmDialogueItemList();
                            if (!swipeRefreshLayout.isRefreshing()) {
                                poetryItemAdapter.addData(dialogueItems);
                            }
                            if (swipeRefreshLayout.isRefreshing()) {
                                poetryItemAdapter.setNewData(dialogueItems);

                                // 不显示动画需要设置在setNewData之后，否则无效
                                poetryItemAdapter.setNotDoAnimationCount(5);
                                swipeRefreshLayout.setRefreshing(false);
                            }
                            poetryItemAdapter.notifyDataSetChanged();
                            poetryItemAdapter.loadMoreComplete();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        String message = e.getMessage();

                        if (message.contains("404")) {
                            ToastUtils.show(R.string.load_end);
                            poetryItemAdapter.loadMoreEnd();
                        } else {
                            //swipeRefreshLayout.setVisibility(View.GONE);
                            ToastUtils.show("失败了");
                            Log.e("debug",message);
                            errorLayout.setVisibility(View.VISIBLE);
                            poetryItemAdapter.loadMoreFail();
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }
}
