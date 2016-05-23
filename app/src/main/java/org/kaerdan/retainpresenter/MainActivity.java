package org.kaerdan.retainpresenter;

import android.os.Bundle;

import org.kaerdan.presenterretainer.Presenter;
import org.kaerdan.presenterretainer.PresenterActivity;

public class MainActivity extends PresenterActivity<MainPresenter, MainActivity> implements Presenter.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(new BlankFragment(), "").commit();
        }
    }

    @Override
    protected MainPresenter onPresenterCreated() {
        return new MainPresenter();
    }

    @Override
    protected MainActivity getPresenterView() {
        return this;
    }
}
