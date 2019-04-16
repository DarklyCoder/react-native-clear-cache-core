package com.darklycoder.rn.clearcache.tasks;

import android.os.AsyncTask;

import com.facebook.react.bridge.Callback;

import java.lang.ref.WeakReference;

/**
 * @author DarklyCoder 2019/4/16
 */
abstract class BaseAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    WeakReference<Callback> mCallback;

    BaseAsyncTask(Callback callback) {
        this.mCallback = new WeakReference<>(callback);
    }

}
