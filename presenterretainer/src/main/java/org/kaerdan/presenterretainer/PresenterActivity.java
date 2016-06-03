package org.kaerdan.presenterretainer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class PresenterActivity<P extends Presenter<V>, V extends Presenter.View> extends AppCompatActivity {

    private boolean mRetained;

    private PresenterManager<P> mPresenterManager;

    protected P getPresenter() {
        return mPresenterManager.getHostPresenter();
    }

    protected P onCreatePresenter() {
        return null;
    }

    protected V getPresenterView() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        onRestoreState();
        super.onCreate(savedInstanceState);
    }

    private void onRestoreState() {
        mPresenterManager = getPresenterManagerFromNCI();

        if (mPresenterManager == null) {
            mPresenterManager = new PresenterManager<>();
        } else if (getPresenter() != null) {
            onPresenterRestored();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        attachViewToPresenter();
        mRetained = false;
    }

    private void attachViewToPresenter() {

        P presenter = getPresenter();

        if (presenter == null) {
            presenter = onCreatePresenter();
            mPresenterManager.setHostPresenter(presenter);
        }

        final V view = getPresenterView();

        if (presenter != null && view != null) {
            presenter.onAttachView(view);
        } else if (presenter == null && view != null) {
            throw new IllegalStateException("You created a view, but didn't provide a " +
                    "presenter for it");
        } else if (presenter != null) {
            throw new IllegalStateException("You provided a presenter, but didn't create view");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        detachViewFromPresenter();
    }

    private void detachViewFromPresenter() {
        P presenter = getPresenter();
        if (presenter != null) {
            presenter.onDetachView();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (!mRetained) {
            mPresenterManager.destroyAllPresenters();
        } else if (!retainPresenter()) {
            P presenter = getPresenter();
            if (presenter != null) {
                mPresenterManager.setHostPresenter(null);
                presenter.onDestroy();
            }
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        NonConfigurationInstances<P> nci = new NonConfigurationInstances<>();

        mRetained = true;
        nci.presenterManager = mPresenterManager;

        nci.custom = onRetainCustomNonConfigurationObject();
        return nci;
    }

    private PresenterManager<P> getPresenterManagerFromNCI() {
        NonConfigurationInstances<P> nci =
                (NonConfigurationInstances<P>) getLastCustomNonConfigurationInstance();
        if (nci != null) {
            return nci.presenterManager;
        }
        return null;
    }

    public Object onRetainCustomNonConfigurationObject() {
        return null;
    }

    public Object getLastCustomNonConfigurationObject() {
        NonConfigurationInstances<P> nci =
                (NonConfigurationInstances<P>) getLastCustomNonConfigurationInstance();
        return nci != null ? nci.custom : null;
    }

    protected void onPresenterRestored() {

    }

    protected boolean retainPresenter() {
        return true;
    }

    PresenterManager<P> getPresenterManager() {
        return mPresenterManager;
    }

    static final class NonConfigurationInstances<P extends Presenter> {
        Object custom;
        PresenterManager<P> presenterManager;
    }
}
