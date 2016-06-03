package org.kaerdan.retainpresenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.kaerdan.presenterretainer.PresenterActivity;

import java.util.List;

public class MainActivity extends PresenterActivity<MainPresenter, MainContract.View> implements MainContract.View {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.button_list);
    }

    @Override
    protected MainPresenter onCreatePresenter() {
        return new MainPresenter();
    }

    @Override
    protected MainActivity getPresenterView() {
        return this;
    }

    @Override
    public void displayButtons(List<Integer> stringIdList) {
        listView.setAdapter(new ArrayAdapter<Integer>(this, 0, stringIdList) {
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                Button button = convertView != null ? (Button) convertView : new Button(parent.getContext());
                button.setText(getItem(position));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().onButtonFromListClicked(position);
                    }
                });
                return button;
            }
        });
    }

    @Override
    public void launchActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    @Override
    protected boolean retainPresenter() {
        return false;
    }
}
