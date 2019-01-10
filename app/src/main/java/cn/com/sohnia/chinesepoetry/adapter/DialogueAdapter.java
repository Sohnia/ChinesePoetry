package cn.com.sohnia.chinesepoetry.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;


import java.util.List;

import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.info.DialogueInfo;
import cn.com.sohnia.chinesepoetry.utils.ImageUtil.ImageLoader;


public class DialogueAdapter extends BaseQuickAdapter<DialogueInfo.DialogueItem, BaseViewHolder> {

    public DialogueAdapter(@Nullable List<DialogueInfo.DialogueItem> data) {
        super(R.layout.item_photo, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DialogueInfo.DialogueItem item) {
        ImageView dialogueImageView = helper.getView(R.id.dialogue_img);
        ImageLoader.loadImageByUrl(dialogueImageView.getContext(), dialogueImageView, item.getmDialogueItemUrl());
    }

}
