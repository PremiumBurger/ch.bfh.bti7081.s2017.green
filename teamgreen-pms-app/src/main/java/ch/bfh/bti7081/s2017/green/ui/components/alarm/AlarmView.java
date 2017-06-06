package ch.bfh.bti7081.s2017.green.ui.components.alarm;

import com.vaadin.navigator.View;

/**
 * Created by joris on 15.05.17.
 */
public interface AlarmView extends View{
    void addListener(AlarmViewListener listener);
    void init();

}
