package org.kaerdan.retainpresenter.fragment_navigation;

public interface FragmentNavigationActivityContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
        void onPreviousClick();
        void onNextClick();
        void onReplace();
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
        void launchActivity(Class<?> cls);
        void replaceContentFragment();
    }
}
