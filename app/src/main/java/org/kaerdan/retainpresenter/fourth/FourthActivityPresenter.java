package org.kaerdan.retainpresenter.fourth;

import org.kaerdan.retainpresenter.third.ThirdActivity;

public class FourthActivityPresenter implements FourthContract.Presenter {

    private FourthContract.View view;
    private boolean isLongRunOpStarted;

    @Override
    public void onAttachView(FourthContract.View view) {
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

    @Override
    public void onPreviousClick() {
        view.launchActivity(ThirdActivity.class);
    }
}
