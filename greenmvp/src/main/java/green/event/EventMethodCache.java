package green.event;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A simple cache for eventhandlers found via reflection.
 * Created by Lukas on 28.05.2017.
 */
public class EventMethodCache implements Serializable {

    private static final long serialVersionUID = -3835595439788993624L;

    private final Map<Class<?>, Set<Method>> methodMap;

    public EventMethodCache () {
        methodMap = new ConcurrentHashMap<>();
    }

    /**
     * Adds a Method to the {@link #methodMap}
     */
    public void addMethodToCache (Class<?> c, Method m) {
        Set<Method> methods = methodMap.get(c);

        if (methods == null) {
            methods = new LinkedHashSet<>();
            methodMap.put(c, methods);
        }

        methods.add(m);
    }


    public void clear () {
        methodMap.clear();
    }


    public void removeCachedOf (Class<?> c) {
        methodMap.remove(c);
    }


    public Set<Method> getMethods (Class<?> c) {
        return methodMap.get(c);
    }


    public boolean isClassCached (Class<?> c) {
        return methodMap.containsKey(c);
    }

}
