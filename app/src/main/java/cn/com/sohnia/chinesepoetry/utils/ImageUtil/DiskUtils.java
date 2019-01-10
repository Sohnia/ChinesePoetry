package cn.com.sohnia.chinesepoetry.utils.ImageUtil;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;
import java.nio.file.Path;


public class DiskUtils {

    public static long getSDAvailableSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs statFs = new StatFs(path.getPath());
        long availableBlock = statFs.getAvailableBlocks();
        long blockSize = statFs.getBlockSize();
        return availableBlock * blockSize;
    }

}
