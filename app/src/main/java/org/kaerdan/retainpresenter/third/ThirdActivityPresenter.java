package org.kaerdan.retainpresenter.third;

import org.kaerdan.retainpresenter.first.FirstActivity;
import org.kaerdan.retainpresenter.fourth.FourthActivity;
import org.kaerdan.retainpresenter.second.SecondActivity;

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
        view.launchActivity(SecondActivity.class);
    }

    @Override
    public void onNextClick() {
        view.launchActivity(FourthActivity.class);
    }

    @Override
    public void onReplace() {
        view.replaceContentFragment();
    }
}
