package org.kaerdan.retainpresenter.fragment_navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.kaerdan.presenterretainer.PresenterActivity;
import org.kaerdan.retainpresenter.R;

public class FragmentNavigationActivity extends PresenterActivity<FragmentNavigationActivityPresenter, FragmentNavigationActivityContract.View>
    implements FragmentNavigationActivityContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_navigation);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, new ScreenFragment(), null)
                    .commit();
        }

        initViews();
    }

    private void initViews() {
        ((TextView) findViewById(R.id.description)).setText(R.string.fragment_navigation_activity_description);

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

        findViewById(R.id.replace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onReplace();
            }
        });
    }

    @Override
    public void launchActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    @Override
    protected FragmentNavigationActivityPresenter onCreatePresenter() {
        return new FragmentNavigationActivityPresenter();
    }

    @Override
    protected FragmentNavigationActivityContract.View getPresenterView() {
        return this;
    }

    @Override
    public void replaceContentFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new ScreenFragment(), null)
                .commit();
    }
}
