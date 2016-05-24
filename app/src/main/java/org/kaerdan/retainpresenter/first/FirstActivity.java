package org.kaerdan.retainpresenter.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.kaerdan.presenterretainer.PresenterActivity;
import org.kaerdan.retainpresenter.R;

public class FirstActivity extends PresenterActivity<FirstContract.Presenter, FirstContract.View>
        implements FirstContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        findViewById(R.id.previous).setVisibility(View.GONE);
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onNextClick();
            }
        });
    }

    @Override
    protected FirstContract.Presenter onCreatePresenter() {
        return new FirstActivityPresenter();
    }

    @Override
    protected FirstContract.View getPresenterView() {
        return this;
    }

    @Override
    public void launchActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
