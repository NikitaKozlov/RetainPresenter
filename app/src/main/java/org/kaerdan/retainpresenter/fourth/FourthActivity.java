package org.kaerdan.retainpresenter.fourth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.kaerdan.presenterretainer.PresenterActivity;
import org.kaerdan.retainpresenter.R;

public class FourthActivity extends PresenterActivity<FourthActivityPresenter, FourthContract.View>
    implements FourthContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, new FourthFragment(), null)
                    .commit();
        }

        findViewById(R.id.previous).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onPreviousClick();
            }
        });

        findViewById(R.id.next).setVisibility(View.INVISIBLE);
    }

    @Override
    protected boolean retainPresenter() {
        return false;
    }

    @Override
    protected FourthActivityPresenter onCreatePresenter() {
        return new FourthActivityPresenter();
    }

    @Override
    protected FourthContract.View getPresenterView() {
        return this;
    }

    @Override
    public void launchActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
