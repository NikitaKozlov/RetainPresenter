package org.kaerdan.presenterretainer;

import android.support.v4.util.SimpleArrayMap;

import java.util.UUID;

public class PresenterManager<HP extends Presenter> {

    private HP mHostPresenter;
    private SimpleArrayMap<UUID, Presenter> mPresenters =
            new SimpleArrayMap<>();

    public void setHostPresenter(HP presenter) {
        this.mHostPresenter = presenter;
    }

    public HP getHostPresenter() {
        return mHostPresenter;
    }

    public Presenter getPresenter(UUID uuid)  {
        return mPresenters.get(uuid);
    }

    public UUID addPresenter(Presenter presenter) {
        final UUID uuid = UUID.randomUUID();
        mPresenters.put(uuid, presenter);
        return uuid;
    }

    public Presenter removePresenter(UUID uuid) {
        return mPresenters.remove(uuid);
    }

    public void destroyAllPresenters() {
        if (mHostPresenter != null) {
            mHostPresenter.onDestroy();
        }

        for (int i = 0; i < mPresenters.size(); i++) {
            Presenter presenter = mPresenters.get(i);
            if (presenter != null) {
                presenter.onDestroy();
            }
        }
    }



}
