package org.kaerdan.retainpresenter;

import android.util.Log;

import org.kaerdan.presenterretainer.Presenter;

public class LogPresenter<T extends Presenter.View> implements Presenter<T> {

    @Override
    public void onAttachView(T view) {
        Log.d(this.getClass().getSimpleName() + " " + hashCode(), "OnAttachedView");
    }

    @Override
    public void onDetachView() {
        Log.d(this.getClass().getSimpleName() + " " + hashCode(), "OnDetachView");
    }

    @Override
    public void onDestroy() {
        Log.d(this.getClass().getSimpleName() + " " + hashCode(), "OnDestroy");
    }
}
