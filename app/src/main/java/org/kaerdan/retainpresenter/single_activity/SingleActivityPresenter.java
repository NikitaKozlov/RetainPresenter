package org.kaerdan.retainpresenter.single_activity;

import org.kaerdan.retainpresenter.LogPresenter;
import org.kaerdan.retainpresenter.single_fragment.SingleFragmentActivity;

public class SingleActivityPresenter extends LogPresenter<SingleActivityContract.View>
        implements SingleActivityContract.Presenter {

    private SingleActivityContract.View view;

    @Override
    public void onAttachView(SingleActivityContract.View view) {
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
    public void onNextClick() {
        view.launchActivity(SingleFragmentActivity.class);
    }
}
