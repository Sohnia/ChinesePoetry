package cn.com.sohnia.chinesepoetry.net;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import cn.com.sohnia.chinesepoetry.Constant;
import cn.com.sohnia.chinesepoetry.app.BaseApplication;
import cn.com.sohnia.chinesepoetry.storage.preference.Preferences;
import me.ghui.fruit.Fruit;
import me.ghui.fruit.converter.retrofit.FruitConverterFactory;
import me.ghui.retrofit.converter.GlobalConverterFactory;
import me.ghui.retrofit.converter.annotations.Html;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


public class ApiServices {

    private static final long TIMEOUT_LENGTH = 15;
    private static APIs mApi;
    private static Fruit mFruit;
    private static OkHttpClient mOkHttpClient;

    public static void init() {
        if (mApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .addConverterFactory(GlobalConverterFactory.create()
                    .add(FruitConverterFactory.create(getFruit()), Html.class))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Constant.BASE_URL_JUZIMI)
                    .build();
            mApi = retrofit.create(APIs.class);
        }
    }

    public static OkHttpClient getOkHttpClient() {

        LoginUtil.initLoginState();

        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .cache(getCache())
                    .addNetworkInterceptor(new StethoInterceptor())
                    .connectTimeout(TIMEOUT_LENGTH, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    // 修改useragent防止请求失效
                    .addInterceptor(chain -> {
                        Request request = chain.request()
                                .newBuilder()
                                .removeHeader("User-Agent")
                                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko")
                                .build();
                        return chain.proceed(request);
                    })
                    // cookie本地持久化
                    .addInterceptor(new ReadCookiesInterceptor())
                    .addInterceptor(new SaveCookiesInterceptor())
                    .build();
        }
        return mOkHttpClient;
    }

    public static Fruit getFruit() {
        if (mFruit == null) {
            mFruit = new Fruit();
        }
        return mFruit;
    }

    public static APIs getAPIs() {
        init();
        return mApi;
    }


    public static Cache getCache(){
        File httpCacheDirectory = new File(BaseApplication.getInstance().getCacheDir(), "okhttp_cache");
        return new Cache(httpCacheDirectory, 10 * 1024 * 1024);         // 缓存空间10M
    }

    //读取Cookie的拦截器
    public static class ReadCookiesInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
            HashSet<String> cookies = Preferences.getCookieInterceptorKey();
                for (String cookie : cookies) {
                    builder.addHeader("Cookie", cookie);
                }
            return chain.proceed(builder.build());
        }
    }

    //存储Cookie的拦截器
    public static class SaveCookiesInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());

            if (!originalResponse.headers("Set-Cookie").isEmpty()) {
                HashSet<String> cookies = new HashSet<>();
                for (String header : originalResponse.headers("Set-Cookie")) {
                    cookies.add(header);
                }
                Preferences.setCookieInterceptorKey(cookies);
            }

            return originalResponse;
        }
    }
}
