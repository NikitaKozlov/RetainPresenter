package org.kaerdan.retainpresenter.single_fragment;

public interface SingleFragmentContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
    }
}
