package org.kaerdan.retainpresenter.third;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.kaerdan.presenterretainer.PresenterFragment;
import org.kaerdan.retainpresenter.R;

public class ThirdFragment extends PresenterFragment<ThirdFragmentPresenter, ThirdFragmentContract.View>
        implements ThirdFragmentContract.View {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    protected ThirdFragmentPresenter onPresenterCreated() {
        return new ThirdFragmentPresenter();
    }

    @Override
    protected ThirdFragment getPresenterView() {
        return this;
    }
}
