package org.kaerdan.retainpresenter.second;

import org.kaerdan.presenterretainer.Presenter;
import org.kaerdan.retainpresenter.LogPresenter;

public class SecondFragmentPresenter extends LogPresenter<SecondFragmentContract.View>
        implements SecondFragmentContract.Presenter {

    private Presenter.View view;

    @Override
    public void onAttachView(SecondFragmentContract.View view) {
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
