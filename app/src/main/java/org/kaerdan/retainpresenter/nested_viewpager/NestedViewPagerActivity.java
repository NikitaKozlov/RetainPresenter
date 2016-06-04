package org.kaerdan.retainpresenter.nested_viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.kaerdan.presenterretainer.PresenterActivity;
import org.kaerdan.retainpresenter.R;

public class NestedViewPagerActivity extends PresenterActivity<NestedViewPagerActivityPresenter,
        NestedViewPagerActivityContract.View> implements NestedViewPagerActivityContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, new ViewPagerFragment(), null)
                    .commit();
        }

        initViews();
    }

    private void initViews() {
        ((TextView) findViewById(R.id.description)).setText(R.string.nested_viewpager_activity_description);

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
    protected NestedViewPagerActivityPresenter onCreatePresenter() {
        return new NestedViewPagerActivityPresenter();
    }

    @Override
    protected NestedViewPagerActivityContract.View getPresenterView() {
        return this;
    }

    @Override
    public void launchActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
