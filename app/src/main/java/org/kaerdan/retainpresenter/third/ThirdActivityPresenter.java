package org.kaerdan.retainpresenter.third;

import org.kaerdan.retainpresenter.first.FirstActivity;

public class ThirdActivityPresenter implements ThirdContract.Presenter {

    private ThirdContract.View view;
    private boolean isLongRunOpStarted;

    @Override
    public void onAttachView(ThirdContract.View view) {
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
        view.launchActivity(FirstActivity.class);
    }

    @Override
    public void onNextClick() {
        view.launchActivity(ThirdActivity.class);
    }

    @Override
    public void onReplace() {
        view.replaceContentFragment();
    }
}
