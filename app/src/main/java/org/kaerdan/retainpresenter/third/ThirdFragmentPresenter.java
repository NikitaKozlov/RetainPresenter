package org.kaerdan.retainpresenter.third;

import org.kaerdan.retainpresenter.LogPresenter;

public class ThirdFragmentPresenter extends LogPresenter<ThirdFragmentContract.View>
        implements ThirdFragmentContract.Presenter {

    private View view;

    @Override
    public void onAttachView(ThirdFragmentContract.View view) {
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
