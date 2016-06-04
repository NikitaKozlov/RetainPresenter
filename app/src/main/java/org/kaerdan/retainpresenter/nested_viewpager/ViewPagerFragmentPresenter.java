package org.kaerdan.retainpresenter.nested_viewpager;

import org.kaerdan.retainpresenter.LogPresenter;

public class ViewPagerFragmentPresenter extends LogPresenter<ViewPagerFragmentContract.View>
        implements ViewPagerFragmentContract.Presenter {

    private static final int PAGE_COUNT = 10;

    private View view;

    @Override
    public void onAttachView(ViewPagerFragmentContract.View view) {
        super.onAttachView(view);
        this.view = view;
        view.showContent(PAGE_COUNT);
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
}
