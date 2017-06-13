package ch.bfh.bti7081.s2017.green.webservice;

import ch.bfh.bti7081.s2017.green.bean.AddressBean;
import ch.bfh.bti7081.s2017.green.bean.LocationBean;
import ch.bfh.bti7081.s2017.green.domain.Address;
import ch.bfh.bti7081.s2017.green.webservice.dto.geocode.GeocodeRequest;

/**
 * Created by Cedric on 12.06.2017.
 */
public interface GoogleGeocodingWebService {

    /**
     *
     * @param address
     * @return
     */
    LocationBean getCoordinatesByAddress(AddressBean address);

}
