package org.kaerdan.retainpresenter.second;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.kaerdan.presenterretainer.PresenterFragment;
import org.kaerdan.retainpresenter.R;

public class SecondFragment extends PresenterFragment<SecondFragmentPresenter, SecondFragmentContract.View>
        implements SecondFragmentContract.View {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    protected SecondFragmentPresenter onPresenterCreated() {
        return new SecondFragmentPresenter();
    }

    @Override
    protected SecondFragment getPresenterView() {
        return this;
    }
}
