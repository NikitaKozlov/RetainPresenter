package org.kaerdan.retainpresenter;

import org.kaerdan.retainpresenter.single_activity.SingleActivity;
import org.kaerdan.retainpresenter.nested_viewpager.NestedViewPagerActivity;
import org.kaerdan.retainpresenter.single_fragment.SingleFragmentActivity;
import org.kaerdan.retainpresenter.fragment_navigation.FragmentNavigationActivity;

import java.util.Arrays;
import java.util.List;

public class MainPresenter extends LogPresenter<MainContract.View>
        implements MainContract.Presenter {

    private List<Integer> stringIdList = Arrays.asList(R.string.single_activity_title,
            R.string.single_fragment_activity_title, R.string.fragment_navigation_activity_title,
            R.string.nested_viewpager_activity_title);

    private List<Class<?>> activityClsList = Arrays.<Class<?>>asList(SingleActivity.class,
            SingleFragmentActivity.class, FragmentNavigationActivity.class, NestedViewPagerActivity.class);

    private MainContract.View view;


    @Override
    public void onAttachView(MainContract.View view) {
        super.onAttachView(view);
        this.view = view;
        view.displayButtons(stringIdList);
    }

    @Override
    public void onDetachView() {
        super.onDetachView();
        this.view = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onButtonFromListClicked(int position) {
        view.launchActivity(activityClsList.get(position));
    }
}
