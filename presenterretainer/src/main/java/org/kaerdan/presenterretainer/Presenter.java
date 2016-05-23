package org.kaerdan.presenterretainer;

public interface Presenter<T extends Presenter.View> {

    void onAttachView(View view);

    void onDetachView();

    void onDestroy();

    interface View {

    }
}
