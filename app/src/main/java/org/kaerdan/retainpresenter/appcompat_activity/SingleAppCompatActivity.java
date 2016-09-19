package org.kaerdan.retainpresenter.appcompat_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.kaerdan.retainpresenter.R;
import org.kaerdan.retainpresenter.single_fragment.SingleFragment;

public class SingleAppCompatActivity extends AppCompatActivity {

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
                //getPresenter().onPreviousClick();
            }
        });

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           //     getPresenter().onNextClick();
            }
        });
    }

    public void launchActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
