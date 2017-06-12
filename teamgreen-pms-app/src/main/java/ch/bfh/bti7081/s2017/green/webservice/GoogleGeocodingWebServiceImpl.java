package ch.bfh.bti7081.s2017.green.webservice;

import ch.bfh.bti7081.s2017.green.AppStart;
import ch.bfh.bti7081.s2017.green.domain.Address;
import ch.bfh.bti7081.s2017.green.util.PmsConstants;
import ch.bfh.bti7081.s2017.green.webservice.dto.Geometry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

@Service
public class GoogleGeocodingWebServiceImpl implements GoogleGeocodingWebService {

    private static final Logger log = LoggerFactory.getLogger(AppStart.class);

    @Value("${ch.bfh.bti7081.s2017.green.webservice.GoogleGeocodingWebServiceImpl.endpoint}")
    private String endpoint;

    @Override
    public Geometry getCoordinatesByAddress(Address address) {
        log.info("GetCoordinatesByAddress called with: address:=" + address);
        final String ext = "?address={address}&key={apiKey}";
        final String requestUrl = endpoint + ext;

        StringJoiner joiner = new StringJoiner("+");

        Map<String, String> params = new HashMap<>();
        params.put("apiKey", PmsConstants.GOOGLE_MAPS_API_KEY);
        params.put("address", joiner.add(address.getStrasse()).add(address.getPlz()).add(address.getCity()).toString());

        RestTemplate restTemplate = new RestTemplate();
        Geometry forObject = restTemplate.getForObject(requestUrl, Geometry.class, params);

        return forObject;
    }
}
