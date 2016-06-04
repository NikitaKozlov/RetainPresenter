package org.kaerdan.retainpresenter.nested_viewpager;

import org.kaerdan.retainpresenter.LogPresenter;

public class NestedFragmentPresenter extends LogPresenter<NestedFragmentContract.View>
        implements NestedFragmentContract.Presenter {

    private View view;

    @Override
    public void onAttachView(NestedFragmentContract.View view) {
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
}
