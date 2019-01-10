package cn.com.sohnia.chinesepoetry.ui.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.RelativeLayout;

import cn.com.sohnia.chinesepoetry.adapter.DialogueAdapter;

public interface IPhotoFragment {
    public RelativeLayout getErrorLayout();

    public SwipeRefreshLayout getSwipeSwipeRefreshLayout();

    public DialogueAdapter getAdapter();
}
