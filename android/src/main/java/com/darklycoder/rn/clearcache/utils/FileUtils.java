package com.darklycoder.rn.clearcache.utils;

import android.content.Context;

import java.io.File;

/**
 * @author DarklyCoder 2019/4/16
 * 文件工具类
 */
public final class FileUtils {

    private File mFilesDir;
    private File mCacheDir;
    private File mExternalCacheDir;

    private FileUtils() {
    }

    private static class FileUtilsInner {
        private static FileUtils instance = new FileUtils();
    }

    public static FileUtils getInstance() {
        return FileUtilsInner.instance;
    }

    /**
     * 确定缓存路径
     */
    public void init(Context context) {
        mFilesDir = context.getFilesDir();// /data/data/package_name/files
        mCacheDir = context.getCacheDir();// /data/data/package_name/cache
        mExternalCacheDir = context.getExternalCacheDir();//"<sdcard>/Android/data/<package_name>/cache/"
    }

    /**
     * 清除缓存
     */
    public void clearCache() {
        clearFile(mFilesDir);
        clearFile(mCacheDir);
        clearFile(mExternalCacheDir);
    }

    /**
     * 获取缓存大小
     *
     * @return 缓存大小
     */
    public String getCacheSize() {
        long fileSize = 0;
        fileSize += getFileSize(mFilesDir);
        fileSize += getFileSize(mCacheDir);
        fileSize += getFileSize(mExternalCacheDir);

        if (fileSize > 0) {
            String size = formatFileSize(fileSize);
            String unit = formatFileSizeName(fileSize);

            return size + unit;
        }

        return "";
    }

    /**
     * 获取目录文件大小
     */
    private long getFileSize(File dir) {
        if (null == dir) {
            return 0;
        }

        if (!dir.isDirectory()) {
            return 0;
        }

        long   dirSize = 0;
        File[] files   = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                dirSize += file.length();
                continue;
            }

            if (file.isDirectory()) {
                dirSize += file.length();
                dirSize += getFileSize(file); // 递归调用继续统计
            }
        }

        return dirSize;
    }

    /**
     * 转换文件大小名称
     *
     * @return B/KB/MB/GB
     */
    private String formatFileSizeName(long fileS) {
        String fileSizeString;

        if (fileS < 1024) {
            fileSizeString = "B";

        } else if (fileS < 1048576) {
            fileSizeString = "KB";

        } else if (fileS < 1073741824) {
            fileSizeString = "MB";

        } else {
            fileSizeString = "G";
        }

        return fileSizeString;
    }

    /**
     * 转换文件大小
     *
     * @return B/KB/MB/GB
     */
    private String formatFileSize(long fileS) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        String                  fileSizeString;
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS);

        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024);

        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576);

        } else {
            fileSizeString = df.format((double) fileS / 1073741824);
        }

        return fileSizeString;
    }

    /**
     * 清除该路径下文件
     */
    private int clearFile(File dir) {
        int  deletedFiles = 0;
        long curTime      = System.currentTimeMillis();

        if (null != dir && dir.isDirectory()) {
            try {
                for (File child : dir.listFiles()) {
                    if (child.isDirectory()) {
                        deletedFiles += clearFile(child);
                    }

                    if (child.lastModified() < curTime) {
                        if (child.delete()) {
                            deletedFiles++;
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return deletedFiles;
    }

}
