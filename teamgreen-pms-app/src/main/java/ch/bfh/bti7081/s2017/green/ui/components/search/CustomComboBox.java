package ch.bfh.bti7081.s2017.green.ui.components.search;

import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.ComboBox;

import java.util.Arrays;
/**
 * Created by mathewthekkekara on 23.05.17.
 */
public class CustomComboBox<T> extends ComboBox<T>{


    @Override
    public void setDataProvider(ListDataProvider<T> listDataProvider) {
        CaptionFilter defaultCaptionFilter = (itemText, filterText) ->
                Arrays.stream(filterText.toLowerCase(getLocale()).split("\\s")).parallel().allMatch(itemText.toLowerCase(getLocale())::contains);
        setDataProvider(defaultCaptionFilter, listDataProvider);
    }
}
