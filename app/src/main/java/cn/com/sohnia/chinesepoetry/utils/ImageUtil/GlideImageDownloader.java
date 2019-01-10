package cn.com.sohnia.chinesepoetry.utils.ImageUtil;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;

import com.bilibili.socialize.share.download.AbsImageDownloader;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import cn.com.sohnia.chinesepoetry.app.BaseApplication;


public class GlideImageDownloader extends AbsImageDownloader {

    @Override
    protected void downloadDirectly(String imageUrl, String filePath, OnImageDownloadListener listener) {

        GlideApp.with(BaseApplication.getInstance())
                .asBitmap()
                .load(imageUrl)
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        listener.onFailed(imageUrl);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        File file = new File(filePath);
                        try {
                            FileOutputStream out = new FileOutputStream(file);
                            resource.compress(Bitmap.CompressFormat.JPEG, 100, out);
                            out.flush();
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        listener.onSuccess(filePath);
                        return false;
                    }
                }).submit();

    }

}
