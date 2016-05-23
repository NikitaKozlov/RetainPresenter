package org.kaerdan.retainpresenter;

import org.kaerdan.retainpresenter.framework.Presenter;

public class MainPresenter implements Presenter<Presenter.View> {

    private View view;
    private boolean isLongRunOpStarted;

    @Override
    public void onAttachView(View view) {
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
