package org.kaerdan.retainpresenter.third;

import org.kaerdan.retainpresenter.LogPresenter;
import org.kaerdan.retainpresenter.nested_viewpager.FourthActivity;
import org.kaerdan.retainpresenter.second.SecondActivity;

public class ThirdActivityPresenter extends LogPresenter<ThirdContract.View>
        implements ThirdContract.Presenter {

    private ThirdContract.View view;

    @Override
    public void onAttachView(ThirdContract.View view) {
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
