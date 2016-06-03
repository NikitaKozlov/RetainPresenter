package org.kaerdan.retainpresenter.fourth;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.kaerdan.presenterretainer.PresenterFragment;
import org.kaerdan.retainpresenter.R;

public class FourthFragment extends PresenterFragment<FourthFragmentPresenter, FourthFragmentContract.View>
        implements FourthFragmentContract.View {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_with_viewpager, container, false);
    }

    @Override
    protected FourthFragmentPresenter onPresenterCreated() {
        return new FourthFragmentPresenter();
    }

    @Override
    protected FourthFragment getPresenterView() {
        return this;
    }

    @Override
    public void showContent(int pageCount) {
        ((ViewPager) getView().findViewById(R.id.viewpager)).setAdapter(
                new NestedFragmentAdapter(getChildFragmentManager(), pageCount));
    }
}
