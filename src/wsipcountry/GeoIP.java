/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsipcountry;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;

/**
 *
 * @author s.bakunowicz
 */
@XmlRootElement(name="GeoIP")
public class GeoIP {

    public String getCountry() {
        return Country;
    }
    
    @XmlElement(name="Country")
    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getState() {
        return State;
    }

    @XmlElement(name="State")
    public void setState(String State) {
        this.State = State;
    }
    String Country;
    String State;
}
