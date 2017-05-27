package ch.bfh.bti7081.s2017.green.event;

import ch.bfh.bti7081.s2017.green.ui.DashboardViewType;

/**
 * Created by Lukas on 26.05.2017.
 */
public final class PostViewChangeEvent {
    private final DashboardViewType view;

    public PostViewChangeEvent (final DashboardViewType view) {
        this.view = view;
    }

    public DashboardViewType getView () {
        return view;
    }
}
