package org.kaerdan.retainpresenter.fragment_navigation;

import org.kaerdan.retainpresenter.LogPresenter;
import org.kaerdan.retainpresenter.nested_viewpager.NestedViewPagerActivity;
import org.kaerdan.retainpresenter.single_fragment.SingleFragmentActivity;

public class FragmentNavigationActivityPresenter extends LogPresenter<FragmentNavigationActivityContract.View>
        implements FragmentNavigationActivityContract.Presenter {

    private FragmentNavigationActivityContract.View view;

    @Override
    public void onAttachView(FragmentNavigationActivityContract.View view) {
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
        view.launchActivity(SingleFragmentActivity.class);
    }

    @Override
    public void onNextClick() {
        view.launchActivity(NestedViewPagerActivity.class);
    }

    @Override
    public void onReplace() {
        view.replaceContentFragment();
    }
}
