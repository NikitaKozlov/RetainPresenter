package org.kaerdan.retainpresenter.nested_viewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private final int pageCount;

    public ViewPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.pageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        return new NestedFragment();
    }

    @Override
    public int getCount() {
        return pageCount;
    }


}
