package cn.com.sohnia.chinesepoetry.jsoup;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import cn.com.sohnia.chinesepoetry.model.PoetryModel;


public class PoetryJsoup {
    private List<PoetryModel> poetryModelList;
    private Document document;

    public PoetryJsoup(Document document) {
        this.document = document;
        poetryModelList = new ArrayList<PoetryModel>();
    }

    public List<PoetryModel> convertToList(){
        Elements elements = document.select("div.sons");
        for(Element element:elements){
            //tmp.setPoetryId(element.select("div.cont p:eq(1) a").attr("href"));
            PoetryModel tmp = new PoetryModel();
            //tmp.setPoetryId(element.select("div.cont p:eq(1) a").attr("href"));
            try {
                tmp.setTitle(element.select("div.cont b").text());
                tmp.setContent(element.select("div.contson").text());
                tmp.setAuthor(element.select("p.source a").text());
                tmp.setLike(element.select("div.good span").text());
                tmp.setType(element.select("div.tag").text());
                if(!"".equals(tmp.getTitle()))
                    poetryModelList.add(tmp);
            }
            catch (Exception e){
                //Log.e("debug",e.getMessage());
            }
            finally {
                tmp = null;
            }
        }
        return poetryModelList;
    }

}
