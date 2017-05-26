package ch.bfh.bti7081.s2017.green;

import ch.bfh.bti7081.s2017.green.ui.MainUI;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

/**
 * Created by mathewthekkekara on 26.05.17.
 */
@WebServlet(value = "/*",asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = MainUI.class,widgetset = "eu.maxschuster.vaadin.autocompletetextfield.demo.DemoWidgetSet")
public class MyServlet extends VaadinServlet{


}
