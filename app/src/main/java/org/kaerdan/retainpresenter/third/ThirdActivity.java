package org.kaerdan.retainpresenter.third;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.kaerdan.presenterretainer.PresenterActivity;
import org.kaerdan.retainpresenter.R;
import org.kaerdan.retainpresenter.second.SecondFragment;

public class ThirdActivity extends PresenterActivity<ThirdActivityPresenter, ThirdContract.View>
    implements ThirdContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        getSupportFragmentManager()
                .beginTransaction()
                .add(new ThirdFragment(), null)
                .commit();
    }

    @Override
    public void launchActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
