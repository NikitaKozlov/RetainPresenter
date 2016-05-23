package org.kaerdan.retainpresenter;

import android.os.Bundle;

import org.kaerdan.retainpresenter.framework.Presenter;
import org.kaerdan.retainpresenter.framework.Presenter.View;
import org.kaerdan.retainpresenter.framework.PresenterActivity;

public class MainActivity extends PresenterActivity implements View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected Presenter onPresenterCreated() {
        return new MainPresenter();
    }

    @Override
    protected View getPresenterView() {
        return this;
    }
}
