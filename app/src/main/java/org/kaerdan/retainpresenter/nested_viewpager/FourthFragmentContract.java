package org.kaerdan.retainpresenter.nested_viewpager;

public interface FourthFragmentContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
        void showContent(int pageCount);
    }
}
