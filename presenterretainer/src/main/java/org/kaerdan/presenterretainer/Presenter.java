package org.kaerdan.presenterretainer;

public interface Presenter<T extends Presenter.View> {

    void onAttachView(T view);

    void onDetachView();

    void onDestroy();

    interface View {

    }
}
