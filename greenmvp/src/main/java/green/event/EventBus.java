package green.event;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 * {@link Event}s can be fired to the {@link EventBus} and the {@link EventBus}
 * is the component, that deliver / dispatch the {@link Event}s to the registered {@link EventHandler}.
 *
 * @author Lukas Läderach
 * @see #fireEvent(Event)
 * @see #addHandler(Object)
 * @see #removeHandler(Object)
 */
@Component
public class EventBus {
    private static final EventMethodCache eventMethodChache = new EventMethodCache();
    private static boolean caching = true;
    private final Map<Class<? extends Event>, Set<EventDispatcher>> handlerMap;


    public EventBus () {
        handlerMap = new ConcurrentHashMap<>();
    }

    /**
     * Enable or disable caching
     */
    public void setUseCache (boolean caching) {
        EventBus.caching = caching;
    }

    /**
     * Get the Class of the {@link Event}.
     * The passed {@link Method} must be a valid {@link EventHandler}-annotated
     * method with exactly one parameter (the {@link Event}).
     * This method is a little helper method and is only used by the {@link EventBus} internally.
     */
    @SuppressWarnings("unchecked")
    private Class<? extends Event> getEventClass (Method m) {
        return (Class<? extends Event>) m.getParameterTypes()[0];
    }

    /**
     * Registers an  {@link EventHandler}
     */
    public void addHandler (Object handler) {

        boolean added;

        if (caching) {
            if (!eventMethodChache.isClassCached(handler.getClass()))
                added = scanHandlerAndCreateEventDispatcher(handler); // This class is not cached, so scan the class
            else
                // This class has been cached (has been already scanned), so build the EventDispatcher from Cache
                added = createEventDispatchersFromCache(handler);
        } else
            added = scanHandlerAndCreateEventDispatcher(handler);

        if (!added)
            throw new Error("No @EventHandler annotated Method found in " + handler.getClass().getName());

    }


    private boolean scanHandlerAndCreateEventDispatcher (Object handler) {
        boolean added = false;
        for (Method m : handler.getClass().getMethods()) {
            if (!m.isAnnotationPresent(EventHandler.class))
                continue;

            Class<?> params[] = m.getParameterTypes();
            if (params.length == 1 && isEventClass(params[0])) {
                // This Method is a Valid EventHandler
                EventDispatcher disp = new EventDispatcher(handler, m);
                addEventDispatcher(getEventClass(m), disp);
                added = true;

                if (caching)
                    eventMethodChache.addMethodToCache(handler.getClass(), m);
            } else
                throw new Error("You have annotated the Method " + m.getName() + " with @EventHandler, " +
                        "but this method did not match the required one Parameter (exactly one) of the type Event");
        }

        return added;
    }


    private boolean isEventClass (Class<?> clazz) {

        Class<?> c = clazz;
        while (c != null) {
            if (c.equals(Event.class))
                return true;

            c = c.getSuperclass();
        }

        return false;

    }

    /**
     * Creates {@link EventDispatcher}s by unsing the {@link EventMethodCache}.
     * That means, that the class of the passed handler has already be scanned for
     * {@link EventHandler} annotations and all information about building the
     * {@link EventDispatcher}s are present in the {@link EventMethodCache}.
     */
    private boolean createEventDispatchersFromCache (Object handler) {

        Set<Method> methods = eventMethodChache.getMethods(handler.getClass());

        if (methods == null)
            throw new Error("The class " + handler.getClass().getName() + " has not been cached until now. However the EventBus tries to create a EventDispatcher from the cache.");

        for (Method m : methods) {
            EventDispatcher disp = new EventDispatcher(handler, m);
            addEventDispatcher(getEventClass(m), disp);
        }

        return !methods.isEmpty();
    }

    /**
     * Add a {@link EventDispatcher} for the passed {@link Event}-Class
     */
    private void addEventDispatcher (Class<? extends Event> eventClass,
                                     EventDispatcher disp) {

        Set<EventDispatcher> dispatchers = handlerMap.get(eventClass);

        if (dispatchers == null) {
            dispatchers = new LinkedHashSet<>();
            handlerMap.put(eventClass, dispatchers);
        }

        dispatchers.add(disp);
    }


    /**
     * Removes an Handler (a Object with {@link EventHandler} annotated methods) from
     * the {@link EventBus}. That means, that future fired {@link Event}s are no longer
     * dispatched / delivered to the passed handler
     */
    public void removeHandler (Object handler) {

        Set<EventDispatcher> toRemove = new LinkedHashSet<>();
        for (Set<EventDispatcher> dispatchers : handlerMap.values()) {
            for (EventDispatcher d : dispatchers)
                if (d.getTarget() == handler)
                    toRemove.add(d);

            dispatchers.removeAll(toRemove);
            toRemove.clear();
        }
    }


    /**
     * Fires a Event to the EventBus to inform all registered EventHandlers about this Event
     *
     * @return true if at least one {@link EventHandler} is registered and has received the passed event,
     * otherwise false
     */
    public boolean fireEvent (Event event) {

        Set<EventDispatcher> dispatchers = handlerMap.get(event.getClass());
        if (dispatchers == null || dispatchers.isEmpty())
            return false;

        for (EventDispatcher disp : dispatchers)
            disp.dispatchEvent(event);

        return true;
    }
}