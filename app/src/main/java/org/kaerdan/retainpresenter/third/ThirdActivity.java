package org.kaerdan.retainpresenter.third;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.kaerdan.presenterretainer.PresenterActivity;
import org.kaerdan.retainpresenter.R;
import org.kaerdan.retainpresenter.second.SecondActivityPresenter;
import org.kaerdan.retainpresenter.second.SecondContract;

public class ThirdActivity extends PresenterActivity<ThirdActivityPresenter, ThirdContract.View>
    implements ThirdContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, new ThirdFragment(), null)
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
    protected ThirdActivityPresenter onCreatePresenter() {
        return new ThirdActivityPresenter();
    }

    @Override
    protected ThirdContract.View getPresenterView() {
        return this;
    }

    @Override
    public void replaceContentFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new ThirdFragment(), null)
                .commit();
    }
}
