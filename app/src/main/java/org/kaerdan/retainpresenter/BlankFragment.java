package org.kaerdan.retainpresenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.kaerdan.presenterretainer.Presenter;
import org.kaerdan.presenterretainer.PresenterFragment;

public class BlankFragment extends PresenterFragment<FragmentPresenter, BlankFragment> implements Presenter.View {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    protected FragmentPresenter onPresenterCreated() {
        return new FragmentPresenter();
    }

    @Override
    protected BlankFragment getPresenterView() {
        return this;
    }
}
