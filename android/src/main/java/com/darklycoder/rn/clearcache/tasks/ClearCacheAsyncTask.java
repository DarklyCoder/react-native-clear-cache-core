package com.darklycoder.rn.clearcache.tasks;

import com.darklycoder.rn.clearcache.utils.FileUtils;
import com.facebook.react.bridge.Callback;

/**
 * @author DarklyCoder 2019/4/16
 * 清除缓存
 */
public class ClearCacheAsyncTask extends BaseAsyncTask<Integer, Integer, String> {

    public ClearCacheAsyncTask(Callback callback) {
        super(callback);
    }

    @Override
    protected String doInBackground(Integer... integers) {
        FileUtils.getInstance().clearCache();

        return FileUtils.getInstance().getCacheSize();
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        try {
            if (null != mCallback && null != mCallback.get()) {
                mCallback.get().invoke(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
