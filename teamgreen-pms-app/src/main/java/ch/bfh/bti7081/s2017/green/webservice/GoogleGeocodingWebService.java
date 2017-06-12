package ch.bfh.bti7081.s2017.green.webservice;

import ch.bfh.bti7081.s2017.green.domain.Address;
import ch.bfh.bti7081.s2017.green.webservice.dto.Geometry;
import com.vaadin.tapio.googlemaps.client.LatLon;

/**
 * Created by Cedric on 12.06.2017.
 */
public interface GoogleGeocodingWebService {

    /**
     *
     * @param address
     * @return
     */
    Geometry getCoordinatesByAddress(Address address);

}
