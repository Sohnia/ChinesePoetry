package cn.com.sohnia.chinesepoetry.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import javax.annotation.Nullable;

import cn.com.sohnia.chinesepoetry.Constant;
import cn.com.sohnia.chinesepoetry.R;
import cn.com.sohnia.chinesepoetry.info.PoetryInfo;
import cn.com.sohnia.chinesepoetry.model.PoetryModel;

public class PoetryItemAdapter extends BaseQuickAdapter<PoetryModel, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public PoetryItemAdapter(@Nullable List<PoetryModel> data) {
        super(R.layout.item_poetry,data);
//        addItemType(Constant.DAY_TIME,R.layout.item_poetry);
    }

    @Override
    protected void convert(BaseViewHolder helper, PoetryModel item) {
        String title = item.getTitle() == null?"未知" : item.getTitle();
        String author = item.getAuthor() == null?"未知" : item.getAuthor();
        String like = item.getLike() == null?"未知" : item.getLike();
        String content = item.getContent() == null?"未知" : item.getContent();
        String type = item.getType() == null?"未知" : item.getType();

        helper.setText(R.id.item_poetry_title,title);
        helper.setText(R.id.item_poetry_content,content);
        helper.setText(R.id.item_poetry_type,type);
        helper.setText(R.id.item_poetry_like,like);
        helper.setText(R.id.item_poetry_author,author);

    }

}
