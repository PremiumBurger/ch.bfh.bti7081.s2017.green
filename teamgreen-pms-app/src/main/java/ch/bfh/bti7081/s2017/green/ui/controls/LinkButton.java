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
        super("<div style='padding:50px'><a style='background-color: red; border-radius: 50px; font-family: Arial; color: #ffffff; font-size: 20px;text-decoration: none; padding: 50%; margin:50px' href=" + externalResource.getURL() + ">" + caption + "</a></div>", ContentMode.HTML
        );
    }
}
