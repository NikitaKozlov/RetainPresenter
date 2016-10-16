package org.kaerdan.retainpresenter.single_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.kaerdan.presenterretainer.PresenterActivity;
import org.kaerdan.retainpresenter.R;

public class SingleFragmentActivity extends PresenterActivity<SingleFragmentActivityPresenter, SingleFragmentActivityContract.View>
    implements SingleFragmentActivityContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, new SingleFragment(), null)
                    .commit();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViews();
    }

    private void initViews() {
        ((TextView) findViewById(R.id.description)).setText(R.string.single_fragment_activity_description);

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
    protected SingleFragmentActivityPresenter onCreatePresenter() {
        return new SingleFragmentActivityPresenter();
    }

    @Override
    protected SingleFragmentActivityContract.View getPresenterView() {
        return this;
    }

    @Override
    public void launchActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
