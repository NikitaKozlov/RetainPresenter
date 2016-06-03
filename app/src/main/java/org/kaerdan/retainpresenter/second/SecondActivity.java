package org.kaerdan.retainpresenter.second;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.kaerdan.presenterretainer.PresenterActivity;
import org.kaerdan.retainpresenter.R;
import org.kaerdan.retainpresenter.first.FirstContract;

public class SecondActivity extends PresenterActivity<SecondActivityPresenter, SecondContract.View>
    implements SecondContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(new SecondFragment(), null)
                    .commit();
        }

        findViewById(R.id.previous).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onPreviousClick();
            }
        });

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onNextClick();
            }
        });
    }

    @Override
    protected boolean retainPresenter() {
        return false;
    }

    @Override
    protected SecondActivityPresenter onCreatePresenter() {
        return new SecondActivityPresenter();
    }

    @Override
    protected SecondContract.View getPresenterView() {
        return this;
    }

    @Override
    public void launchActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
