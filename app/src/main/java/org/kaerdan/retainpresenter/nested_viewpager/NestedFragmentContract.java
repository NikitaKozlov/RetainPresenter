package org.kaerdan.retainpresenter.nested_viewpager;

public interface NestedFragmentContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
    }
}
