package org.kaerdan.retainpresenter.fourth;

import org.kaerdan.retainpresenter.LogPresenter;
import org.kaerdan.retainpresenter.third.ThirdActivity;

public class FourthActivityPresenter extends LogPresenter<FourthContract.View>
        implements FourthContract.Presenter {

    private FourthContract.View view;

    @Override
    public void onAttachView(FourthContract.View view) {
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
        view.launchActivity(ThirdActivity.class);
    }
}
