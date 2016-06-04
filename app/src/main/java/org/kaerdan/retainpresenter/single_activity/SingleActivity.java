package org.kaerdan.retainpresenter.single_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.kaerdan.presenterretainer.PresenterActivity;
import org.kaerdan.retainpresenter.R;

public class SingleActivity extends PresenterActivity<SingleActivityContract.Presenter, SingleActivityContract.View>
        implements SingleActivityContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initViews();
    }

    private void initViews() {
        ((TextView) findViewById(R.id.description)).setText(R.string.single_activity_description);

        findViewById(R.id.previous).setVisibility(View.INVISIBLE);
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onNextClick();
            }
        });
    }

    @Override
    protected SingleActivityContract.Presenter onCreatePresenter() {
        return new SingleActivityPresenter();
    }

    @Override
    protected SingleActivityContract.View getPresenterView() {
        return this;
    }

    @Override
    public void launchActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
