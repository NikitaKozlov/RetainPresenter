package org.kaerdan.retainpresenter.fourth;

import org.kaerdan.retainpresenter.LogPresenter;

public class FourthFragmentPresenter extends LogPresenter<FourthFragmentContract.View>
        implements FourthFragmentContract.Presenter {

    private static final int PAGE_COUNT = 10;

    private View view;

    @Override
    public void onAttachView(FourthFragmentContract.View view) {
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
