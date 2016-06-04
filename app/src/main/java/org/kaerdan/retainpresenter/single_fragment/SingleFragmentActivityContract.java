package org.kaerdan.retainpresenter.single_fragment;

public interface SingleFragmentActivityContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
        void onPreviousClick();
        void onNextClick();
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
        void launchActivity(Class<?> cls);
    }
}
