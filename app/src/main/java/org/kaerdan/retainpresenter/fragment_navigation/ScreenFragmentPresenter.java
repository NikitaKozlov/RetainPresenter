package org.kaerdan.retainpresenter.fragment_navigation;

import org.kaerdan.retainpresenter.LogPresenter;

public class ScreenFragmentPresenter extends LogPresenter<ScreenFragmentContract.View>
        implements ScreenFragmentContract.Presenter {

    private View view;

    @Override
    public void onAttachView(ScreenFragmentContract.View view) {
        super.onAttachView(view);
        this.view = view;
    }

    @Override
    public void onDetachView() {
        super.onDetachView();
        this.view = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
