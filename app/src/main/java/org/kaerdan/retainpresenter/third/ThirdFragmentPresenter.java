package org.kaerdan.retainpresenter.third;

public class ThirdFragmentPresenter implements ThirdFragmentContract.Presenter {

    private View view;
    private boolean isLongRunOpStarted;

    @Override
    public void onAttachView(ThirdFragmentContract.View view) {
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
