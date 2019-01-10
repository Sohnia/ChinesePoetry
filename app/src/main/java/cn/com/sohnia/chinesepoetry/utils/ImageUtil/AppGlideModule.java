package cn.com.sohnia.chinesepoetry.utils.ImageUtil;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.request.RequestOptions;

import cn.com.sohnia.chinesepoetry.Constant;
import cn.com.sohnia.chinesepoetry.app.BaseApplication;

@GlideModule
public class AppGlideModule extends com.bumptech.glide.module.AppGlideModule {

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
    }


    @Override
    public void applyOptions(Context context, GlideBuilder builder) {

        long availableDiskSize = DiskUtils.getSDAvailableSize();
        long diskCacheSizeBytes = availableDiskSize > 500 * Constant.MB ? 250 * Constant.MB : availableDiskSize / 2;

        //设置磁盘缓存
        builder.setDiskCache(new InternalCacheDiskCacheFactory(
                BaseApplication.getInstance(),
                Constant.CachePath,
                diskCacheSizeBytes));

        //添加默认请求配置
        builder.setDefaultRequestOptions(
                new RequestOptions().format(DecodeFormat.PREFER_RGB_565).disallowHardwareConfig()
        );
    }
}
