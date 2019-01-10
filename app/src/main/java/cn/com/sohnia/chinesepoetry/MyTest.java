package cn.com.sohnia.chinesepoetry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.com.sohnia.chinesepoetry.info.DialogueInfo;
import cn.com.sohnia.chinesepoetry.info.PoetryInfo;
import cn.com.sohnia.chinesepoetry.model.PoetryModel;
import me.ghui.fruit.Fruit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyTest {
    public static void main(String agv[]) throws IOException {
//        Request request = new Request.Builder().url(Constant.BASE_URL + "/default.aspx?page=1").build();
//        String BaseUrl  = "https://www.juzimi.com/meitumeiju/jingdianduibai";
//        Document doc = Jsoup.connect(Constant.BASE_URL + "/default.aspx?page=1").get();
//        PoetryInfo poetryInfo= new Fruit().fromHtml(doc, PoetryInfo.class);
//        System.out.println(poetryInfo.getPoetryItems());
        Document document = Jsoup.connect(Constant.BASE_URL + "/default.aspx?page=1").get();
//        Elements elements = doc.select("div.cont b");
        Elements elements = document.select("div.sons");
        List<PoetryModel> poetryModelList = new ArrayList<PoetryModel>();
        for(Element element:elements){
//            System.out.println(element);
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
        System.out.println(poetryModelList);



    }
}
