package org.kaerdan.retainpresenter.third;

import org.kaerdan.retainpresenter.first.FirstActivity;

public class ThirdActivityPresenter implements ThirdContract.Presenter {

    private ThirdContract.View view;

    @Override
    public void onAttachView(ThirdContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onPreviousClick() {
        view.launchActivity(FirstActivity.class);
    }

    @Override
    public void onNextClick() {
        view.launchActivity(ThirdActivity.class);
    }
}
