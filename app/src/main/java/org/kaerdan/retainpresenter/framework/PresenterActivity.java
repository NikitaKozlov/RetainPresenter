package org.kaerdan.retainpresenter.framework;

import android.support.v7.app.AppCompatActivity;

public class PresenterActivity<P extends Presenter, V extends Presenter.View> extends AppCompatActivity {

    private P mPresenter;
    private boolean mRetained;

    protected P getPresenter() {
        return mPresenter;
    }

    protected P onPresenterCreated() {
        return null;
    }

    protected V getPresenterView() {
        return null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        attachViewToPresenter();
        mRetained = false;
    }

    private void attachViewToPresenter() {

        if (mPresenter == null) {
           getLastCustomNonConfigurationInstance();
        }

        if (mPresenter == null) {
            mPresenter = onPresenterCreated();
        }

        final V view = getPresenterView();

        if (mPresenter != null && view != null) {
            mPresenter.onAttachView(view);
        } else {
            //TODO Error check
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        detachViewFromPresenter();
    }

    private void detachViewFromPresenter() {
        if (mPresenter != null) {
            mPresenter.onDetachView();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!mRetained) {
            mPresenter.onDestroy();
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        if (retainPresenter()) {
            mRetained = true;
            return mPresenter;
        }
        return super.onRetainCustomNonConfigurationInstance();
    }

    @Override
    public Object getLastCustomNonConfigurationInstance() {
        Object lcnci = super.getLastCustomNonConfigurationInstance();
        mPresenter = (P) lcnci;
        onPresenterRestored();
        return lcnci;
    }

    protected void onPresenterRestored() {

    }

    protected boolean retainPresenter() {
        return true;
    }


}
