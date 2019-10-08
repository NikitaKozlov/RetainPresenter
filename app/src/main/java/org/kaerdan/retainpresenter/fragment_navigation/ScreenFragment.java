package org.kaerdan.retainpresenter.fragment_navigation;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.ColorInt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.kaerdan.presenterretainer.PresenterFragment;
import org.kaerdan.retainpresenter.R;

import java.util.Random;

public class ScreenFragment extends PresenterFragment<ScreenFragmentPresenter, ScreenFragmentContract.View>
        implements ScreenFragmentContract.View {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        v.setBackgroundColor(getRandomColor());
        return v;
    }

    @ColorInt
    private int getRandomColor() {
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        return Color.rgb(r,g,b);
    }

    @Override
    protected ScreenFragmentPresenter onCreatePresenter() {
        return new ScreenFragmentPresenter();
    }

    @Override
    protected ScreenFragment getPresenterView() {
        return this;
    }
}
