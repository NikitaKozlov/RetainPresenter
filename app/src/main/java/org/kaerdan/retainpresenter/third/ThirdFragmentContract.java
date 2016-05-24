package org.kaerdan.retainpresenter.third;

public interface ThirdFragmentContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
    }
}
