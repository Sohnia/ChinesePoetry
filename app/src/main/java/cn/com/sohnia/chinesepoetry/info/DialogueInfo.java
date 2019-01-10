package cn.com.sohnia.chinesepoetry.info;

import java.util.List;

import me.ghui.fruit.annotations.Pick;

public class DialogueInfo extends BaseInfo {

    @Pick("div.views-field-phpcode")
    private List<DialogueItem> mDialogueItemList;

    public List<DialogueItem> getmDialogueItemList() {
        return mDialogueItemList;
    }

    public void setmDialogueItemList(List<DialogueItem> mDialogueItemList) {
        this.mDialogueItemList = mDialogueItemList;
    }

    @Override
    public String toString() {
        return "DialogueInfo{" +
                "mDialogueItemList=" + mDialogueItemList +
                '}';
    }

    public static class DialogueItem {

        @Pick(value = "img.chromeimg", attr = "src")
        private String mDialogueItemUrl;

        public String getmDialogueItemUrl() {
            return "http:" + mDialogueItemUrl;
        }

        public void setmDialogueItemUrl(String mDialogueItemUrl) {
            this.mDialogueItemUrl = mDialogueItemUrl;
        }

        @Override
        public String toString() {
            return "DialogueItem{" +
                    "mDialogueItemUrl='" + mDialogueItemUrl + '\'' +
                    '}';
        }
    }

    @Override
    public boolean isValid() {
        return true;
    }

}
