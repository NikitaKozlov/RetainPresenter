package org.kaerdan.retainpresenter.single_fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.kaerdan.presenterretainer.PresenterFragment;
import org.kaerdan.retainpresenter.R;

import java.util.Random;

public class SingleFragment extends PresenterFragment<SingleFragmentPresenter, SingleFragmentContract.View>
        implements SingleFragmentContract.View {

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
    protected SingleFragmentPresenter onCreatePresenter() {
        return new SingleFragmentPresenter();
    }

    @Override
    protected SingleFragment getPresenterView() {
        return this;
    }
}
