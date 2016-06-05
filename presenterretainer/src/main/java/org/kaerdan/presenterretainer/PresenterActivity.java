package org.kaerdan.presenterretainer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class PresenterActivity<P extends Presenter<V>, V extends Presenter.View> extends AppCompatActivity {

    private PresenterManager<P> mPresenterManager;

    /**
     * Provides presenter.
     * @return Presenter if it was created.
     *         null otherwise.
     */
    protected P getPresenter() {
        return mPresenterManager.getHostPresenter();
    }

    /**
     * Called after presenter restored. Called before {@link #onCreate(Bundle)}.
     * View is not attached to presenter at this moment.
     */
    protected void onPresenterRestored() {

    }

    /**
     * Method to instantiate presenter. Called during {@link #onStart()}
     * @return new Presenter.
     *         null if {@link #getPresenterView()} returns null.
     *         Otherwise {@link IllegalStateException} will be thrown.
     */
    protected P onCreatePresenter() {
        return null;
    }

    /**
     * Method to instantiate Presenter.View for presenter. Called during {@link #onStart()}
     * @return View for presenter.
     *         null if {@link #onCreatePresenter()} returns null.
     *         Otherwise {@link IllegalStateException} will be thrown.
     */
    protected V getPresenterView() {
        return null;
    }

    /**
     * Indicates if presenter should be kept or not.
     * @return true if presenter should be retained, false otherwise.
     *         Default value is true
     */
    protected boolean retainPresenter() {
        return true;
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
        if (!retainPresenter() || !isChangingConfigurations()) {
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


    /**
     * Use this instead of {@link #onRetainCustomNonConfigurationInstance()}}.
     * Retrieve later with {@link #getLastCustomNonConfigurationObject()}.
     */
    public Object onRetainCustomNonConfigurationObject() {
        return null;
    }

    /**
     * @return value previously returned from
     *         {@link #onRetainCustomNonConfigurationObject()}
     */
    public Object getLastCustomNonConfigurationObject() {
        NonConfigurationInstances<P> nci =
                (NonConfigurationInstances<P>) getLastCustomNonConfigurationInstance();
        return nci != null ? nci.custom : null;
    }


    PresenterManager<P> getPresenterManager() {
        return mPresenterManager;
    }

    static final class NonConfigurationInstances<P extends Presenter> {
        Object custom;
        PresenterManager<P> presenterManager;
    }
}
