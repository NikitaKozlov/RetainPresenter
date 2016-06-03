package org.kaerdan.retainpresenter.first;

import org.kaerdan.retainpresenter.R;
import org.kaerdan.retainpresenter.second.SecondActivity;

import java.util.Arrays;
import java.util.List;

public class FirstActivityPresenter implements FirstContract.Presenter {

    private FirstContract.View view;
    private boolean isLongRunOpStarted;

    @Override
    public void onAttachView(FirstContract.View view) {
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
    public void onNextClick() {
        view.launchActivity(SecondActivity.class);
    }
}
