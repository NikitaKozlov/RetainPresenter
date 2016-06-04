package org.kaerdan.retainpresenter.nested_viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.kaerdan.presenterretainer.PresenterFragment;
import org.kaerdan.retainpresenter.R;

public class ViewPagerFragment extends PresenterFragment<ViewPagerFragmentPresenter, ViewPagerFragmentContract.View>
        implements ViewPagerFragmentContract.View {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_viewpager, container, false);
    }

    @Override
    protected ViewPagerFragmentPresenter onCreatePresenter() {
        return new ViewPagerFragmentPresenter();
    }

    @Override
    protected ViewPagerFragment getPresenterView() {
        return this;
    }

    @Override
    public void showContent(int pageCount) {
        ((ViewPager) getView().findViewById(R.id.viewpager)).setAdapter(
                new ViewPagerAdapter(getChildFragmentManager(), pageCount));
    }
}
