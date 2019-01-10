package cn.com.sohnia.chinesepoetry.net;

import cn.com.sohnia.chinesepoetry.info.AuthorInfo;
import cn.com.sohnia.chinesepoetry.info.DialogueInfo;
import cn.com.sohnia.chinesepoetry.info.PoetryInfo;
import io.reactivex.Observable;
import me.ghui.retrofit.converter.annotations.Html;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIs {
    /**
     * 推荐
     * @param page 页数
     * @return
     */
    @GET("/default.aspx")@Html
    Observable<PoetryInfo> getRecommend(@Query("page") int page);

    /**
     * 诗文
     * @param column 行分类
     * @param s 分类标签 不为空字符串
     * @param page 该分类下的页数
     * @return
     */
    @GET("/shiwen/default_{column}A{s}A{page}.aspx")@Html
    Observable<PoetryInfo> getVariousPoetry(@Path("column")int column,
                                            @Path("s") String s,
                                            @Path("page")int page);

    /**
     * 美句
     * @param page 页数
     * @param theme 主题 不为空字符串
     * @param label 分类 不为空字符串
     * @return
     */
    @GET("/mingju/Default.aspx")@Html
    Observable<PoetryInfo> getSentences(@Query("p")int page,
                                           @Query("c") String theme,
                                           @Query("t")String label);

    /**
     * 作者
     * @param page 页数
     * @param dynasty 朝代，这个参数可以为空字符串，为空字符串时为不限
     * @return
     */
    @GET("/authors/Default.aspx")@Html
    Observable<AuthorInfo> getAuthor(@Query("p") int page, @Query("c")String dynasty);

    /**
     * 搜索作者
     * @param author 作者名
     * @return
     */
    @GET("/search.aspx?type=author&")@Html
    Observable<AuthorInfo> searchAuthor(@Query("value")String author);

    /**
     * 搜索诗文
     * @param title 题目
     * @return
     */
    @GET("/search.aspx?type=title&")@Html
    Observable<PoetryInfo> searchTitle(@Query("value")String title);


    /**
     * 搜索古文
     * @param book 书籍
     * @return
     */
//    @GET("/search.aspx?type=guwen")@Html
//    Observable<> searchBook(@Query("value")String book);

    /**
     *juzimi.com 经典对白
     */
    @HTTP(path = "https://www.juzimi.com/meitumeiju/jingdianduibai",method = "GET")@Html
    Observable<DialogueInfo> getDialoguePage(@Query("page") int page);
}
