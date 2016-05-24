package org.kaerdan.retainpresenter.first;

public interface FirstContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
        void onNextClick();
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
        void launchActivity(Class<?> cls);
    }
}
