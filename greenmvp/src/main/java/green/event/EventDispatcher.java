package green.event;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * The {@link EventDispatcher} is responsible for dispatching / delivering
 * a Event to the corresponding {@link EventHandler} - Method.
 * This is realized by using reflections, especially {@link Method#invoke(Object, Object...)}
 *
 * @author Lukas Läderach
 */
public class EventDispatcher implements Serializable {

    private static final long serialVersionUID = -7359501691640084178L;

    private final Object target;
    private final Method method;


    public EventDispatcher(Object target, Method method) {
        this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }

    public Object getTarget() {
        return target;
    }

    public void dispatchEvent(Object event) {

        try {
            method.invoke(target, event);
        } catch (IllegalArgumentException e) {
            throw new Error("Method rejected target/argument: " + event, e);
        } catch (IllegalAccessException e) {
            throw new Error("Method became inaccessible: " + event, e);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof Error) {
                throw (Error) e.getCause();
            } else
                throw new Error(e);
        }
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        return (PRIME + method.hashCode()) * PRIME
                + System.identityHashCode(target);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof EventDispatcher) {
            EventDispatcher other = (EventDispatcher) o;
            return target == other.target && method.equals(other.method);
        }

        return false;
    }
}
