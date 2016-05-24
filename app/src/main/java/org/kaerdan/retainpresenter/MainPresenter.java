package org.kaerdan.retainpresenter;

import org.kaerdan.retainpresenter.first.FirstActivity;
import org.kaerdan.retainpresenter.second.SecondActivity;
import org.kaerdan.retainpresenter.third.ThirdActivity;

import java.util.Arrays;
import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private List<Integer> stringIdList = Arrays.asList(R.string.first_activity_title,
            R.string.second_activity_title, R.string.third_activity_title);

    private List<Class<?>> activityClsList = Arrays.<Class<?>>asList(FirstActivity.class,
            SecondActivity.class, ThirdActivity.class);

    private MainContract.View view;


    @Override
    public void onAttachView(MainContract.View view) {
        this.view = view;
        view.displayButtons(stringIdList);
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onButtonFromListClicked(int position) {
        view.launchActivity(activityClsList.get(position));
    }
}
