package org.kaerdan.retainpresenter.fourth;

public interface FourthFragmentContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
        void showContent(int pageCount);
    }
}
