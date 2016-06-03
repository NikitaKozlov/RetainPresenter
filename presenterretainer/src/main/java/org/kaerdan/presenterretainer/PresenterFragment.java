package org.kaerdan.presenterretainer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class PresenterFragment<P extends Presenter, V extends Presenter.View> extends Fragment {

    private static final String PRESENTER_SAVE_UUID = "Presenter save uuid tag";

    private UUID mPresenterUUID;

    private PresenterManager mPresenterManager;

    protected P getPresenter() {
        if (mPresenterUUID != null) {
            return (P) mPresenterManager.getPresenter(mPresenterUUID);
        }
        return null;
    }

    protected P onPresenterCreated() {
        return null;
    }

    protected V getPresenterView() {
        return null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PresenterActivity) {
            mPresenterManager = ((PresenterActivity) context).getPresenterManager();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onRestoreState(savedInstanceState);
    }

    private void onRestoreState(@Nullable Bundle savedInstanceState)  {
        if (savedInstanceState != null) {
            mPresenterUUID = (UUID) savedInstanceState.getSerializable(PRESENTER_SAVE_UUID);
            P presenter = getPresenter();
            if (presenter != null) {
                onPresenterRestored();
            }
        }
    }

    protected void onPresenterRestored() {

    }

    @Override
    public void onStart() {
        super.onStart();
        attachViewToPresenter();
    }

    private void attachViewToPresenter() {

        P presenter = getPresenter();

        if (presenter == null) {
            presenter = onPresenterCreated();
            mPresenterUUID = mPresenterManager.addPresenter(presenter);
        }

        final V view = getPresenterView();

        if (presenter != null && view != null) {
            presenter.onAttachView(view);
        } else if (presenter == null && view != null) {
            throw new IllegalStateException("You created a presenter, but didn't provide a " +
                    "view for it");
        } else if (presenter != null) {
            throw new IllegalStateException("You provided a view, but didn't create presenter");
        }
    }

    @Override
    public void onStop() {
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
    public void onDestroy() {
        super.onDestroy();
        if (!retainPresenter() || !getActivity().isChangingConfigurations()) {
            P presenter = getPresenter();
            if (presenter != null) {
                mPresenterManager.removePresenter(mPresenterUUID);
                presenter.onDestroy();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(PRESENTER_SAVE_UUID, mPresenterUUID);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenterManager = null;
    }

    protected boolean retainPresenter() {
        return true;
    }
}
