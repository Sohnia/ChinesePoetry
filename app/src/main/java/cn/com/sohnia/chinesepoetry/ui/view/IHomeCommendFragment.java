package cn.com.sohnia.chinesepoetry.ui.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.RelativeLayout;

import cn.com.sohnia.chinesepoetry.adapter.PoetryItemAdapter;

public interface IHomeCommendFragment {
    public PoetryItemAdapter getAdapter();
    public SwipeRefreshLayout getSwipeSwipeRefreshLayout();
    public RelativeLayout getErrorLayout();

}
