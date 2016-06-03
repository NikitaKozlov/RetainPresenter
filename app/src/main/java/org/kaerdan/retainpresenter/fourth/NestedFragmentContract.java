package org.kaerdan.retainpresenter.fourth;

public interface NestedFragmentContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
    }
}
