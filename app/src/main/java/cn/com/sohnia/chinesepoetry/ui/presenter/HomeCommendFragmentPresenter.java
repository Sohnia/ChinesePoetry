package cn.com.sohnia.chinesepoetry.ui.presenter;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

import cn.com.sohnia.chinesepoetry.Constant;
import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.adapter.PoetryItemAdapter;
import cn.com.sohnia.chinesepoetry.jsoup.PoetryJsoup;
import cn.com.sohnia.chinesepoetry.model.PoetryModel;
import cn.com.sohnia.chinesepoetry.storage.preference.Preferences;
import cn.com.sohnia.chinesepoetry.ui.base.BasePresenter;
import cn.com.sohnia.chinesepoetry.ui.view.IHomeCommendFragment;
import cn.com.sohnia.chinesepoetry.utils.TimeUtils;
import cn.com.sohnia.chinesepoetry.utils.ToastUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeCommendFragmentPresenter extends BasePresenter<IHomeCommendFragment> {
    private IHomeCommendFragment iHomeCommendFragment;
    private Context context;
    private int mCurrentPage;
    private PoetryItemAdapter poetryItemAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RelativeLayout errorLayout;
    private String TAG = "HomeCommendFragmentPresenter";

    public HomeCommendFragmentPresenter(Context context) {
        this.context = context;
        String data = new TimeUtils().getCurrentDate();
        if (data.equals(Preferences.getCurrentData()))
            { mCurrentPage = Preferences.getCommendFragmentPage();}
        else{
            Preferences.setCurrentData(data);
            Preferences.setCommendFragmentPage(1);
        }
    }

    public void pullToRefresh(boolean isLoadMore) {
        mCurrentPage = isLoadMore ? ++mCurrentPage:Preferences.getCommendFragmentPage();;
        loadData(mCurrentPage);
    }

    public void loadData(int page) {
        if (iHomeCommendFragment == null){
            iHomeCommendFragment = getView();
            errorLayout = iHomeCommendFragment.getErrorLayout();
            swipeRefreshLayout = iHomeCommendFragment.getSwipeSwipeRefreshLayout();
            poetryItemAdapter = iHomeCommendFragment.getAdapter();
        }
        Observable.create(new ObservableOnSubscribe<Document>() {
            @Override
            public void subscribe(ObservableEmitter<Document> emitter) throws Exception {
                Document doc = Jsoup.connect(String.format("%s/default.aspx?page=%s", Constant.BASE_URL, mCurrentPage)).get();
                emitter.onNext(doc);

            }
        }).observeOn(AndroidSchedulers.mainThread())//回调在主线程
                .subscribeOn(Schedulers.io())//执行在io线程
                .subscribe(new Observer<Document>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(Document document) {
//                        Log.e(TAG,"onNext:"+element.toString());
                        List<PoetryModel> poetryItems = new PoetryJsoup(document).convertToList();

                        if (poetryItems == null) {
                            ToastUtils.show(R.string.load_fail);
                            swipeRefreshLayout.setRefreshing(false);
                            poetryItemAdapter.loadMoreEnd();
                        }
                        if (poetryItems!= null) {
                            if (!swipeRefreshLayout.isRefreshing()) {
                                poetryItemAdapter.addData(poetryItems);
                                Log.i("debug_home_frgt",poetryItems.toString());
                            }
                            if (swipeRefreshLayout.isRefreshing()) {
//                                Log.i("debug_home_frgt",poetryItems.toString());
                                poetryItemAdapter.setNewData(poetryItems);
                                // 不显示动画需要设置在setNewData之后，否则无效
                                poetryItemAdapter.setNotDoAnimationCount(5);
                                swipeRefreshLayout.setRefreshing(false);
                            }
                            // 由于添加了headerview,所以从下标1开始刷新
                            poetryItemAdapter.notifyDataSetChanged();
                            poetryItemAdapter.loadMoreComplete();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtils.show("失败了");
                        errorLayout.setVisibility(View.VISIBLE);
                        poetryItemAdapter.loadMoreFail();
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
//        ApiServices.getAPIs().getRecommend(page).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<PoetryInfo>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                    }
//                    @Override
//                    public void onNext(PoetryInfo poetryInfo) {
//                        if (poetryInfo == null) {
//                            ToastUtils.show(R.string.load_fail);
//                            swipeRefreshLayout.setRefreshing(false);
//                        }
//                        if (poetryInfo!= null) {
//                            List<PoetryInfo.PoetryItem> poetryItems = poetryInfo.getPoetryItems();
//                            if (!swipeRefreshLayout.isRefreshing()) {
//                                poetryItemAdapter.addData(poetryItems);
//                                Log.i("debug_home_frgt",poetryItems.toString());
//                            }
//                            if (swipeRefreshLayout.isRefreshing()) {
//                                Log.i("debug_home_frgt",poetryItems.toString());
//                                poetryItemAdapter.setNewData(poetryItems);
//                                // 不显示动画需要设置在setNewData之后，否则无效
//                                poetryItemAdapter.setNotDoAnimationCount(5);
//                                swipeRefreshLayout.setRefreshing(false);
//                            }
//
//                            // 由于添加了headerview,所以从下标1开始刷新
//                            poetryItemAdapter.notifyDataSetChanged();
//                            poetryItemAdapter.loadMoreComplete();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        String message = e.getMessage();
//
//                        if (message.contains("404")) {
//                            ToastUtils.show(R.string.load_end);
//                            poetryItemAdapter.loadMoreEnd();
//                        } else {
//                            //swipeRefreshLayout.setVisibility(View.GONE);
//                            ToastUtils.show("失败了");
//                            Log.e("debug",message);
//                            errorLayout.setVisibility(View.VISIBLE);
//                            poetryItemAdapter.loadMoreFail();
//                            swipeRefreshLayout.setRefreshing(false);
//                        }
//                    }
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    public int getmCurrentPage() {
        return mCurrentPage;
    }
}
