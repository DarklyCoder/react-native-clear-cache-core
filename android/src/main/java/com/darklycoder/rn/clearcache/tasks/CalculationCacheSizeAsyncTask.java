package com.darklycoder.rn.clearcache.tasks;

import com.darklycoder.rn.clearcache.utils.FileUtils;
import com.facebook.react.bridge.Callback;

/**
 * @author DarklyCoder 2019/4/16
 * 计算缓存大小
 */
public class CalculationCacheSizeAsyncTask extends BaseAsyncTask<Integer, Integer, String> {

    public CalculationCacheSizeAsyncTask(Callback callback) {
        super(callback);
    }

    @Override
    protected String doInBackground(Integer... integers) {
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
