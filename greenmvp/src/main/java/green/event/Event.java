package green.event;

import java.io.Serializable;

/**
 * This is the super base type for every event, that can be fired to the {@link EventBus}
 * Created by Lukas Läderach
 */
public class Event implements Serializable {
    private static final long serialVersionUID = -2678661979380772303L;
}
