package org.kaerdan.retainpresenter.single_activity;

public interface SingleActivityContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
        void onNextClick();
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
        void launchActivity(Class<?> cls);
    }
}
