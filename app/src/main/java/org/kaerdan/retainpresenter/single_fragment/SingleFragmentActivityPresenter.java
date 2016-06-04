package org.kaerdan.retainpresenter.single_fragment;

import org.kaerdan.retainpresenter.LogPresenter;
import org.kaerdan.retainpresenter.single_activity.SingleActivity;
import org.kaerdan.retainpresenter.fragment_navigation.FragmentNavigationActivity;

public class SingleFragmentActivityPresenter extends LogPresenter<SingleFragmentActivityContract.View>
        implements SingleFragmentActivityContract.Presenter {

    private SingleFragmentActivityContract.View view;

    @Override
    public void onAttachView(SingleFragmentActivityContract.View view) {
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
        view.launchActivity(FragmentNavigationActivity.class);
    }
}
