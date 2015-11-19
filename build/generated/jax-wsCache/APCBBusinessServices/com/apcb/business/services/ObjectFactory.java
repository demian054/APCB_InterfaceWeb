
package com.apcb.business.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.apcb.business.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TicketAirAvailAndPrice_QNAME = new QName("http://services.business.apcb.com/", "ticketAirAvailAndPrice");
    private final static QName _TicketAirAvailAndPriceResponse_QNAME = new QName("http://services.business.apcb.com/", "ticketAirAvailAndPriceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.apcb.business.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TicketAirAvailAndPriceResponse }
     * 
     */
    public TicketAirAvailAndPriceResponse createTicketAirAvailAndPriceResponse() {
        return new TicketAirAvailAndPriceResponse();
    }

    /**
     * Create an instance of {@link TicketAirAvailAndPrice }
     * 
     */
    public TicketAirAvailAndPrice createTicketAirAvailAndPrice() {
        return new TicketAirAvailAndPrice();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketAirAvailAndPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "ticketAirAvailAndPrice")
    public JAXBElement<TicketAirAvailAndPrice> createTicketAirAvailAndPrice(TicketAirAvailAndPrice value) {
        return new JAXBElement<TicketAirAvailAndPrice>(_TicketAirAvailAndPrice_QNAME, TicketAirAvailAndPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketAirAvailAndPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.business.apcb.com/", name = "ticketAirAvailAndPriceResponse")
    public JAXBElement<TicketAirAvailAndPriceResponse> createTicketAirAvailAndPriceResponse(TicketAirAvailAndPriceResponse value) {
        return new JAXBElement<TicketAirAvailAndPriceResponse>(_TicketAirAvailAndPriceResponse_QNAME, TicketAirAvailAndPriceResponse.class, null, value);
    }

}
