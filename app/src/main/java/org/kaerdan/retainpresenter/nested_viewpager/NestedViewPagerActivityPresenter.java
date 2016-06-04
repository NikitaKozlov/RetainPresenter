package org.kaerdan.retainpresenter.nested_viewpager;

import org.kaerdan.retainpresenter.LogPresenter;
import org.kaerdan.retainpresenter.fragment_navigation.FragmentNavigationActivity;

public class NestedViewPagerActivityPresenter extends LogPresenter<NestedViewPagerActivityContract.View>
        implements NestedViewPagerActivityContract.Presenter {

    private NestedViewPagerActivityContract.View view;

    @Override
    public void onAttachView(NestedViewPagerActivityContract.View view) {
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
        view.launchActivity(FragmentNavigationActivity.class);
    }
}
