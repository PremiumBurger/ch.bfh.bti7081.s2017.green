package ch.bfh.bti7081.s2017.green.ui.components.autcomplete;

import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.ComboBox;

import java.util.Arrays;
/**
 * Created by mathewthekkekara on 23.05.17.
 * instantiate this class for a searchbox which makes a google like search
 * The serach Input can be space separated,
 * All the objects which have minimum one attribute containing all searchwords will be returned
 */
public class Autocomplete<T extends Autocompletable> extends ComboBox<T>{

    public Autocomplete() {
        setItemCaptionGenerator(T::getSearchString);
    }

    /**
     * Method to overwrite the standard search method of the combobox
     * @param listDataProvider dataproovider for the search container
     * */
    @Override
    public void setDataProvider(ListDataProvider<T> listDataProvider) {
        CaptionFilter defaultCaptionFilter = (itemText, filterText) -> Arrays.stream(filterText.toLowerCase(getLocale()).split("\\s")).parallel().allMatch(itemText.toLowerCase(getLocale())::contains);
        setDataProvider(defaultCaptionFilter, listDataProvider);
    }
}
