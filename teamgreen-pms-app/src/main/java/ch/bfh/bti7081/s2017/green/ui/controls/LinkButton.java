package ch.bfh.bti7081.s2017.green.ui.controls;

import com.vaadin.server.ExternalResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;

/**
 * Created by joris on 12.06.17.
 */
public class LinkButton extends Label {

    public LinkButton(String caption, ExternalResource externalResource){
        super(   "<a style='text-decoration: none; background-color:red' href='"+externalResource.getURL()+"'>" +
                "<div class='v-button' tabindex='0'>" +
                "<span class='v-button-wrap'>" +
                "<span class='v-button-caption'>"+
                caption +
                "</span>"+
                "</span>"+
                "</div>"+
                "</a>", ContentMode.HTML
        );
    }
}
