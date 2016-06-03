package org.kaerdan.retainpresenter.first;

import android.util.Log;

import org.kaerdan.retainpresenter.LogPresenter;
import org.kaerdan.retainpresenter.second.SecondActivity;

import java.util.logging.Logger;

public class FirstActivityPresenter extends LogPresenter<FirstContract.View>
        implements FirstContract.Presenter {

    private FirstContract.View view;

    @Override
    public void onAttachView(FirstContract.View view) {
        super.onAttachView(view);
        this.view = view;
    }

    @Override
    public void onDetachView() {
        super.onDetachView();
        this.view = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onNextClick() {
        view.launchActivity(SecondActivity.class);
    }
}
