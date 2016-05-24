package org.kaerdan.retainpresenter;

import java.util.List;

public interface MainContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
        void onButtonFromListClicked(int position);
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
        void displayButtons(List<Integer> stringIdList);
        void launchActivity(Class<?> cls);
    }
}
