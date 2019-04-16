
package com.darklycoder.rn.clearcache;

import com.darklycoder.rn.clearcache.tasks.CalculationCacheSizeAsyncTask;
import com.darklycoder.rn.clearcache.tasks.ClearCacheAsyncTask;
import com.darklycoder.rn.clearcache.utils.FileUtils;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNClearCacheModule extends ReactContextBaseJavaModule {

    public RNClearCacheModule(ReactApplicationContext reactContext) {
        super(reactContext);

        FileUtils.getInstance().init(reactContext);
    }

    @Override
    public String getName() {
        return "RNClearCache";
    }

    /**
     * 获取缓存大小
     *
     * @param callback 回调
     */
    @ReactMethod
    public void getCacheSize(Callback callback) {
        CalculationCacheSizeAsyncTask task = new CalculationCacheSizeAsyncTask(callback);
        task.execute(1);
    }

    /**
     * 清除缓存
     *
     * @param callback
     */
    @ReactMethod
    public void clearCache(Callback callback) {
        ClearCacheAsyncTask task = new ClearCacheAsyncTask(callback);
        task.execute(1);
    }

}