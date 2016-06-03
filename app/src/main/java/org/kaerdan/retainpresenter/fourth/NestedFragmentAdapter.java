package org.kaerdan.retainpresenter.fourth;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class NestedFragmentAdapter extends FragmentStatePagerAdapter {

    private final int pageCount;

    public NestedFragmentAdapter(FragmentManager fm, int pageCount) {
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
