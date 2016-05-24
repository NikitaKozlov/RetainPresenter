package org.kaerdan.retainpresenter.second;

import org.kaerdan.retainpresenter.first.FirstActivity;
import org.kaerdan.retainpresenter.third.ThirdActivity;

public class SecondActivityPresenter implements SecondContract.Presenter {

    private SecondContract.View view;

    @Override
    public void onAttachView(SecondContract.View view) {
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
