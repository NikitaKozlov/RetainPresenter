package org.kaerdan.retainpresenter.fourth;

public class FourthFragmentPresenter implements FourthFragmentContract.Presenter {

    private static final int PAGE_COUNT = 10;

    private View view;
    private boolean isLongRunOpStarted;

    @Override
    public void onAttachView(FourthFragmentContract.View view) {
        this.view = view;
        isLongRunOpStarted = true;
        view.showContent(PAGE_COUNT);
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
