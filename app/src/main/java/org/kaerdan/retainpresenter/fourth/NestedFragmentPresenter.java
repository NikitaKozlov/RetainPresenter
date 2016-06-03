package org.kaerdan.retainpresenter.fourth;

public class NestedFragmentPresenter implements NestedFragmentContract.Presenter {

    private View view;
    private boolean isLongRunOpStarted;

    @Override
    public void onAttachView(NestedFragmentContract.View view) {
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
