package org.kaerdan.presenterretainer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class PresenterManager<HP extends Presenter> {

    private HP mHostPresenter;
    private Map<UUID, Presenter> mPresenters =
            new HashMap<>();

    void setHostPresenter(HP presenter) {
        this.mHostPresenter = presenter;
    }

    HP getHostPresenter() {
        return mHostPresenter;
    }

    Presenter getPresenter(UUID uuid)  {
        return mPresenters.get(uuid);
    }

    UUID addPresenter(Presenter presenter) {
        final UUID uuid = UUID.randomUUID();
        mPresenters.put(uuid, presenter);
        return uuid;
    }

    Presenter removePresenter(UUID uuid) {
        return mPresenters.remove(uuid);
    }
}
