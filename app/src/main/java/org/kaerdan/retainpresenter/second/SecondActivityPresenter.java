package org.kaerdan.retainpresenter.second;

import org.kaerdan.retainpresenter.LogPresenter;
import org.kaerdan.retainpresenter.single_activity.SingleActivity;
import org.kaerdan.retainpresenter.third.ThirdActivity;

public class SecondActivityPresenter extends LogPresenter<SecondContract.View>
        implements SecondContract.Presenter {

    private SecondContract.View view;

    @Override
    public void onAttachView(SecondContract.View view) {
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

    @Override
    public void onPreviousClick() {
        view.launchActivity(SingleActivity.class);
    }

    @Override
    public void onNextClick() {
        view.launchActivity(ThirdActivity.class);
    }
}
