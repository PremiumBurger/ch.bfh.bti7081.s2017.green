package green.mvp.presenter;

import green.mvp.event.EventBus;
import green.mvp.view.View;

import java.io.Serializable;

/**
 * Created by Lukas on 28.05.2017.
 */
public class Presenter <T extends View> implements Serializable {

    private static final long serialVersionUID = -8062395775037001922L;

    private T view;
    private EventBus eventBus;

    public Presenter(){}

    public Presenter (T view)
    {
        setView(view);
    }

    public Presenter(T view, EventBus eventBus)
    {
        setView(view);
        setEventBus(eventBus);
    }

    /**
     * Get the {@link View} that is associated to this presenter
     */
    public T getView(){
        return view;
    }

    /**
     * Set the view
     */
    public void setView(T view){
        this.view = view;
    }

    /**
     * Get the {@link EventBus} to fire any Event's you want to
     */
    public EventBus getEventBus() {
        return eventBus;
    }

    /**
     * Set the {@link EventBus}
     */
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

}
