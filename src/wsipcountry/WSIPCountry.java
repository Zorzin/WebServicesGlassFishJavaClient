/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsipcountry;

import com.lavasoft.GeoIPService;
import com.lavasoft.GeoIPServiceSoap;
import com.lavasoft.GetIpLocationResponse;
import com.lavasoft.GetLocationResponse;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;

/**
 *
 * @author s.bakunowicz
 */
public class WSIPCountry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException {
        
        GeoIPService ipService = new GeoIPService();
        GeoIPServiceSoap serviceMethods = ipService.getGeoIPServiceSoap();
        
        //String ipAddress = args[0];
        //System.out.println("Client 1 IP: " + ipAddress);
        //GeoIP responseIP = ipSoap.getGeoIP("ip");
        
        String response = serviceMethods.getLocation();
        
        JAXBContext jaxbContext = JAXBContext.newInstance(GeoIP.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(response);
        GeoIP geoIp = (GeoIP) jaxbUnmarshaller.unmarshal(reader);
        System.out.println("Klient otrzymał - Country: " + geoIp.getCountry());
        System.out.println("Klient otrzymał - State: " + geoIp.getState());
    }
    
}
