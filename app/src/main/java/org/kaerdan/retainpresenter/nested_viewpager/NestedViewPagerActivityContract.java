package org.kaerdan.retainpresenter.nested_viewpager;

public interface NestedViewPagerActivityContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
        void onPreviousClick();
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
        void launchActivity(Class<?> cls);
    }
}
