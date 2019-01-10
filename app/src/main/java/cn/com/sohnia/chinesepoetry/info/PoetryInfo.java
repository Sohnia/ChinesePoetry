package cn.com.sohnia.chinesepoetry.info;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

import me.ghui.fruit.annotations.Pick;

public class PoetryInfo extends BaseInfo {

    @Pick(value = "div.sons")
    private List<PoetryItem> poetryItems;


    public PoetryInfo(List<PoetryItem> poetryItems) {
        this.poetryItems = poetryItems;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String toString() {
        return "PoetryInfo{" +
                "poetryItems=" + poetryItems +
                '}';
    }

    public List<PoetryItem> getPoetryItems() {
        return poetryItems;
    }

    public void setPoetryItems(List<PoetryItem> poetryItems) {
        this.poetryItems = poetryItems;
    }


    public static class PoetryItem implements Parcelable {
        @Pick(value = "div.cont p:eq(1) a",attr = "href")
        private String poetryId;

        @Pick(value = "div.cont b")
        private String title;

        @Pick(value = "div.contson")
        private String content;

        @Pick(value = "p.source > a:eq(2)")
        private String ahthor;

        @Pick(value = "div.good span")
        private String like;

        @Pick(value = "div.tag")
        private String type;

//        private long date;
//
//        private int itemUIType = 0;

        protected PoetryItem(Parcel in) {
            poetryId = in.readString();
            title = in.readString();
            content = in.readString();
            ahthor = in.readString();
            like = in.readString();
            type = in.readString();
//            date = in.readLong();
        }

        public static final Creator<PoetryItem> CREATOR = new Creator<PoetryItem>() {
            @Override
            public PoetryItem createFromParcel(Parcel in) {
                PoetryItem poetryItem = new PoetryItem();
                poetryItem.setPoetryId(in.readString());
                poetryItem.setAhthor(in.readString());
                poetryItem.setContent(in.readString());
                poetryItem.setTitle(in.readString());
                poetryItem.setLike(in.readString());
                poetryItem.setType(in.readString());
//                poetryItem.setDate(in.readLong());
                return poetryItem;
            }

            @Override
            public PoetryItem[] newArray(int size) {
                return new PoetryItem[size];
            }
        };

        public PoetryItem() {
        }

        public PoetryItem(String poetryId, String title, String content, String ahthor, String like, String type, long date) {
            this.poetryId = poetryId;
            this.title = title;
            this.content = content;
            this.ahthor = ahthor;
            this.like = like;
            this.type = type;
//            this.date = date;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(poetryId);
            parcel.writeString(title);
            parcel.writeString(content);
            parcel.writeString(ahthor);
            parcel.writeString(like);
            parcel.writeString(type);
//            parcel.writeLong(date);
        }

//        @Override
//        public int getItemType() {
//            return getItemUIType();
//        }

        public String getPoetryId() {
            return poetryId;
        }

        public void setPoetryId(String poetryId) {
            this.poetryId = poetryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAhthor() {
            return ahthor;
        }

        public void setAhthor(String ahthor) {
            this.ahthor = ahthor;
        }

        public String getLike() {
            return "喜欢:"+like.replace(" ", "");
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

//        public long getDate() {
//            return date;
//        }
//
//        public void setDate(long date) {
//            this.date = date;
//        }
//
//        public int getItemUIType() {
//            return itemUIType;
//        }
//
//        public void setItemUIType(int itemUIType) {
//            this.itemUIType = itemUIType;
//        }

        @Override
        public String toString() {
            return "PoetryItem{" +
                    "poetryId='" + poetryId + '\'' +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", ahthor='" + ahthor + '\'' +
                    ", like='" + like + '\'' +
                    ", type='" + type + '\'' +
//                    ", date=" + date +
//                    ", itemUIType=" + itemUIType +
                    '}';
        }
    }

}
