package org.kaerdan.retainpresenter.fourth;

public interface FourthContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
        void onPreviousClick();
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
        void launchActivity(Class<?> cls);
    }
}
