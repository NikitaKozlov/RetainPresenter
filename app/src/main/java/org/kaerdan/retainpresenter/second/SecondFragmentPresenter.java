package org.kaerdan.retainpresenter.second;

import org.kaerdan.presenterretainer.Presenter;

public class SecondFragmentPresenter implements SecondFragmentContract.Presenter {

    private Presenter.View view;
    private boolean isLongRunOpStarted;

    @Override
    public void onAttachView(SecondFragmentContract.View view) {
        this.view = view;
        isLongRunOpStarted = true;
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }

    @Override
    public void onDestroy() {
        isLongRunOpStarted = false;
    }
}
