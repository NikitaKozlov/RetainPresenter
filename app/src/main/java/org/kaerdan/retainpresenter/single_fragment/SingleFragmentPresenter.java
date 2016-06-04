package org.kaerdan.retainpresenter.single_fragment;

import org.kaerdan.presenterretainer.Presenter;
import org.kaerdan.retainpresenter.LogPresenter;

public class SingleFragmentPresenter extends LogPresenter<SingleFragmentContract.View>
        implements SingleFragmentContract.Presenter {

    private Presenter.View view;

    @Override
    public void onAttachView(SingleFragmentContract.View view) {
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
